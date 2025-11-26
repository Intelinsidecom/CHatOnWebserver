package com.coolots.chaton.common.controller.translation;

import com.coolots.chaton.SECConfig;
import com.coolots.chaton.setting.data.ChatONHideMeImgData;
import com.csli.eztalky.CSVRecognizer;
import com.csli.eztalky.VRecognitionListener;
import com.samsung.voiceshell.VoiceEngine;
import com.samsung.voiceshell.VoiceEngineWrapper;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.common.controller.translation.engine.RecognitionEngine;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class RecognitionEngineChangsin extends RecognitionEngine implements VRecognitionListener {
    private boolean mIsTranslating;
    private boolean mIsTranslationThreadRunning;
    private int mIsVoice;
    private PipedInputStream mPin;
    private PipedOutputStream mPout;
    private CSVRecognizer mRequestor;
    private VoiceEngine mSamsungVoiceEngine;
    private TranslationThread mTranslationThread;
    private int RECORD_BUFFER_SIZE = ChatONHideMeImgData.IMAGE_DEFAULT_HEIGHT;
    private Object mLock = new Object();

    public void logE(String message) {
        Log.m2958e("[RecognitionEngineChangsin]" + message);
    }

    public void logI(String message) {
        Log.m2954d("[RecognitionEngineChangsin]" + message);
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public void init() {
        super.init();
        this.mSamsungVoiceEngine = VoiceEngineWrapper.getInstance();
        this.mSamsungVoiceEngine.initializeNS();
    }

    public void setLanguage(int voiceLanguage, int translatedLanguage) {
        super.setLangauge(voiceLanguage, translatedLanguage);
        stopTranslation(1);
        startTranslation();
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public Set<Integer> getSupportedLanguage() {
        return getSupportedLanguages();
    }

    public Set<Integer> getSupportedLanguages() {
        Set<Integer> language = new HashSet<>();
        language.add(20);
        language.add(10);
        return language;
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public boolean isSupportedLanguage(int voiceLanguage) {
        Set<Integer> language = getSupportedLanguage();
        return language.contains(Integer.valueOf(voiceLanguage));
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public int getVoiceLanguage() {
        return this.mVoiceLanguage;
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public void start() {
        super.start();
        logI("start()");
        startTranslation();
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public void stop() {
        logI("stop()");
        stopTranslation(1);
        super.stop();
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public void dispose() {
        logI("dispose()");
        stopTranslation(1);
        this.mSamsungVoiceEngine = null;
        super.dispose();
    }

    @Override // com.csli.eztalky.CSListener
    public void onError(int errorCode) {
        logI("onError errorCode=" + errorCode);
        if (this.mIsTranslating) {
            stopTranslation(3);
        }
        logE("onError");
        if (!this.mIsTranslating) {
            startTranslation();
        }
    }

    @Override // com.csli.eztalky.VRecognitionListener
    public void onEndVR() {
        logI("onEndVR");
        this.mIsTranslationThreadRunning = false;
    }

    @Override // com.csli.eztalky.VRecognitionListener
    public void onPreparedVR() {
        logI("onPreparedVR");
    }

    @Override // com.csli.eztalky.VRecognitionListener
    public void onStartVR() {
        logI("onStartVR");
        notifyRecognitionStart();
        this.mIsTranslating = true;
    }

    @Override // com.csli.eztalky.VRecognitionListener
    public void recognitionCompleted(String recognized) throws InterruptedException {
        logI("recognitionCompleted recognized=" + recognized);
        notifyRecognitionEnd(toValidRecognizedString(recognized));
        if (this.mIsTranslating) {
            stopTranslation(3);
        }
        if (!this.mIsTranslating) {
            if (this.mRequestor != null) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            startTranslation();
        }
    }

    private synchronized void startTranslation() {
        logI("startTranslation");
        if (this.mRequestor == null) {
            this.mRequestor = new CSVRecognizer();
        }
        this.mRequestor.setVRecognitionListener(this);
        this.mRequestor.setIp("14.63.223.243");
        if (this.mVoiceLanguage == 10) {
            this.mRequestor.setPort(EventCode.EVENT_CHAT_REFRESH_ROOMLIST);
        } else {
            this.mRequestor.setPort(5210);
        }
        this.mRequestor.setDebug(false);
        this.mPout = new PipedOutputStream();
        try {
            this.mPin = new PipedInputStream(this.mPout, this.RECORD_BUFFER_SIZE * 10);
            this.mRequestor.recognize(this.mPin);
            if (this.mTranslationThread == null) {
                this.mTranslationThread = new TranslationThread();
                this.mIsTranslationThreadRunning = true;
                this.mTranslationThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized void stopTranslation(int type) {
        logI("stopTranslation");
        this.mIsTranslating = false;
        if (this.mRequestor != null) {
            if (type == 0) {
                this.mRequestor.finishVR();
            } else if (type == 1) {
                this.mRequestor.cancel();
            }
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
            }
            if (this.mTranslationThread != null) {
                this.mIsTranslationThreadRunning = false;
                this.mTranslationThread.interrupt();
            }
            if (type != 0) {
                closePipe();
                this.mRequestor.close();
                synchronized (this.mLock) {
                    this.mTranslationThread = null;
                }
                this.mRequestor = null;
            }
        }
    }

    private void closePipe() throws IOException {
        if (this.mPin != null) {
            try {
                this.mPin.close();
                this.mPin = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.mPout != null) {
            try {
                this.mPout.close();
                this.mPout = null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    private class TranslationThread extends Thread {
        private static final int TRANSLATION_BUFFER_SIZE = 8000;
        private ByteBuffer buffer = ByteBuffer.allocateDirect(8000);

        public TranslationThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IOException {
            RecognitionEngineChangsin.this.logI("TranslationThread run()");
            CallStatusData callInfo = new CallStatusData();
            MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
            int epd_cnt = 0;
            boolean bSpeech = false;
            boolean epd = false;
            boolean vad = false;
            while (RecognitionEngineChangsin.this.mIsTranslationThreadRunning) {
                byte[] audioData = new byte[RecognitionEngineChangsin.this.RECORD_BUFFER_SIZE];
                int status = SECConfig.jniGetTxPCM(audioData, 0, RecognitionEngineChangsin.this.RECORD_BUFFER_SIZE);
                if (callInfo.getCallState() == 5) {
                    for (int i = 0; i < RecognitionEngineChangsin.this.RECORD_BUFFER_SIZE; i++) {
                        audioData[i] = 0;
                    }
                }
                RecognitionEngineChangsin.this.logI("TranslationThread#run status=" + status);
                if (status == 0) {
                    short[] shorts = new short[audioData.length / 2];
                    ByteBuffer.wrap(audioData).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(shorts);
                    ShortBuffer shortBuffer = ShortBuffer.allocate(shorts.length);
                    shortBuffer.put(shorts);
                    shortBuffer.position(0);
                    short[] dst = new short[160];
                    for (int j = 0; j < 2; j++) {
                        int oldPosition = shortBuffer.position();
                        shortBuffer.get(dst);
                        int oldIsVoice = RecognitionEngineChangsin.this.mIsVoice;
                        RecognitionEngineChangsin.this.mIsVoice = RecognitionEngineChangsin.this.mSamsungVoiceEngine.processNSFrame(dst, dst.length);
                        shortBuffer.position(oldPosition);
                        shortBuffer.put(dst);
                        if (oldIsVoice == 1 && RecognitionEngineChangsin.this.mIsVoice == 0) {
                            RecognitionEngineChangsin.this.logI("speech -> silence");
                            epd_cnt = 0;
                            if (!vad || j != 1) {
                                vad = false;
                            }
                        } else if (oldIsVoice == 0 && RecognitionEngineChangsin.this.mIsVoice == 1) {
                            RecognitionEngineChangsin.this.logI("silence -> speech");
                            epd_cnt = 0;
                            if (!vad || j != 1) {
                                vad = false;
                            }
                        } else if (oldIsVoice == 0 && RecognitionEngineChangsin.this.mIsVoice == 0) {
                            if (bSpeech && (epd_cnt = epd_cnt + 1) == 2) {
                                epd = true;
                                RecognitionEngineChangsin.this.logI("end by EPD (100 frame silence)");
                                Thread t = new Thread(new Runnable() { // from class: com.coolots.chaton.common.controller.translation.RecognitionEngineChangsin.TranslationThread.1
                                    @Override // java.lang.Runnable
                                    public void run() throws InterruptedException {
                                        RecognitionEngineChangsin.this.mRequestor.finishVR();
                                        RecognitionEngineChangsin.this.logI("voice recognizing >> processing...");
                                    }
                                });
                                t.start();
                                bSpeech = false;
                            }
                            if (!vad || j != 1) {
                                vad = false;
                            }
                        } else if (oldIsVoice == 1 && RecognitionEngineChangsin.this.mIsVoice == 1) {
                            if (!bSpeech) {
                                RecognitionEngineChangsin.this.logI("silence -> real silence");
                                vad = true;
                                bSpeech = true;
                            } else if (!vad || j != 1) {
                                vad = false;
                            }
                        } else if (!vad || j != 1) {
                            vad = false;
                        }
                    }
                    shortBuffer.position(0);
                    shortBuffer.get(shorts);
                    ByteBuffer.wrap(audioData).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(shorts);
                    try {
                        if (RecognitionEngineChangsin.this.mIsTranslating) {
                            if (bSpeech || epd) {
                                if (this.buffer.remaining() >= RecognitionEngineChangsin.this.RECORD_BUFFER_SIZE) {
                                    this.buffer.put(audioData);
                                    if (this.buffer.remaining() == 0) {
                                        RecognitionEngineChangsin.this.mPout.write(this.buffer.array(), 0, this.buffer.position());
                                        this.buffer.clear();
                                    }
                                } else if (this.buffer.remaining() > 0 && this.buffer.remaining() < RecognitionEngineChangsin.this.RECORD_BUFFER_SIZE) {
                                    int remain_size = RecognitionEngineChangsin.this.RECORD_BUFFER_SIZE - this.buffer.remaining();
                                    this.buffer.put(audioData, 0, this.buffer.remaining());
                                    RecognitionEngineChangsin.this.mPout.write(this.buffer.array(), 0, this.buffer.position());
                                    this.buffer.clear();
                                    this.buffer.put(audioData, RecognitionEngineChangsin.this.RECORD_BUFFER_SIZE - remain_size, remain_size);
                                }
                            }
                        }
                    } catch (Exception e) {
                    }
                    synchronized (RecognitionEngineChangsin.this.mLock) {
                        try {
                            Thread.sleep(5L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            this.buffer = null;
        }
    }
}
