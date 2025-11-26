package com.coolots.chaton.common.controller.translation;

import com.coolots.chaton.SECConfig;
import com.coolots.chaton.common.controller.translation.util.TranslationUtil;
import com.coolots.chaton.setting.data.ChatONHideMeImgData;
import com.samsung.voiceserviceplatform.clientsdk.internal.SpeexBits;
import com.samsung.voiceserviceplatform.clientsdk.internal.SpeexJNI;
import com.samsung.voiceshell.VoiceEngine;
import com.samsung.voiceshell.VoiceEngineWrapper;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.common.controller.translation.engine.RecognitionEngine;
import com.sds.coolots.common.util.Log;
import com.voiceengine.NmspHandler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class RecognitionEngineNuance extends RecognitionEngine implements NmspHandler.OnAsrResultListener {
    private SpeexBits mBits;
    private long mEncoderId;
    private int mFrameSize;
    private boolean mIsTranslating;
    private boolean mIsTranslationThreadRunning;
    private int mIsVoice;
    private RecognitionThread mRecognitionThread;
    private VoiceEngine mSamsungVoiceEngine;
    private NmspHandler mNmspHandler = null;
    private SpeexJNI mSpeexEncoder = null;
    private int RECORD_BUFFER_SIZE = ChatONHideMeImgData.IMAGE_DEFAULT_HEIGHT;
    private Object mLock = new Object();

    public void logE(String message) {
        Log.m2958e("[RecognitionEngineNuance]" + message);
    }

    public void logI(String message) {
        Log.m2954d("[RecognitionEngineNuance]" + message);
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public void init() {
        super.init();
        this.mSamsungVoiceEngine = VoiceEngineWrapper.getInstance();
        this.mSamsungVoiceEngine.initializeNS();
        if (this.mNmspHandler == null) {
            this.mNmspHandler = new NmspHandler(MainApplication.mContext, this);
        }
        if (this.mSpeexEncoder == null) {
            this.mSpeexEncoder = new SpeexJNI();
            this.mBits = new SpeexBits();
            this.mEncoderId = this.mSpeexEncoder.speex_encoder_init();
            Long frame_size = new Long(0L);
            this.mSpeexEncoder.speex_encoder_ctl(this.mEncoderId, 3, frame_size);
            this.mFrameSize = frame_size.intValue();
        }
    }

    public void setLanguage(int voiceLanguage, int translatedLanguage) {
        super.setLangauge(voiceLanguage, translatedLanguage);
        stopRecognition();
        startRecognition();
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public Set<Integer> getSupportedLanguage() {
        return getSupportedLanguages();
    }

    public Set<Integer> getSupportedLanguages() {
        Set<Integer> language = new HashSet<>();
        language.add(20);
        language.add(10);
        language.add(31);
        language.add(40);
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
        startRecognition();
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public void stop() {
        logI("stop()");
        stopRecognition();
        super.stop();
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public void dispose() {
        logI("dispose()");
        stopRecognition();
        if (this.mNmspHandler != null) {
            this.mNmspHandler.shutdown();
            this.mNmspHandler = null;
        }
        if (this.mSpeexEncoder != null) {
            this.mSpeexEncoder.speex_encoder_destroy(this.mEncoderId);
            this.mSpeexEncoder = null;
            this.mEncoderId = 0L;
        }
        this.mSamsungVoiceEngine = null;
        super.dispose();
    }

    private void startRecognition() {
        logI("startRecognition()");
        this.mNmspHandler.start(TranslationUtil.getParamLanguage(this.mVoiceLanguage));
        if (this.mRecognitionThread == null) {
            this.mRecognitionThread = new RecognitionThread(this, null);
            this.mIsTranslationThreadRunning = true;
            this.mRecognitionThread.start();
        }
        this.mIsTranslating = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRecognition() {
        logI("stopRecognition()");
        this.mIsTranslating = false;
        if (this.mRecognitionThread != null) {
            this.mIsTranslationThreadRunning = false;
            this.mRecognitionThread.interrupt();
        }
        if (this.mNmspHandler != null) {
            this.mNmspHandler.stop();
        }
        this.mRecognitionThread = null;
    }

    private class RecognitionThread extends Thread {
        private RecognitionThread() {
        }

        /* synthetic */ RecognitionThread(RecognitionEngineNuance recognitionEngineNuance, RecognitionThread recognitionThread) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            RecognitionEngineNuance.this.logI("RecognitionThread run()++");
            CallStatusData callInfo = new CallStatusData();
            MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
            while (RecognitionEngineNuance.this.mIsTranslationThreadRunning) {
                byte[] audioData = new byte[RecognitionEngineNuance.this.RECORD_BUFFER_SIZE];
                int status = SECConfig.jniGetTxPCM(audioData, 0, RecognitionEngineNuance.this.RECORD_BUFFER_SIZE);
                if (callInfo.getCallState() == 5) {
                    for (int i = 0; i < RecognitionEngineNuance.this.RECORD_BUFFER_SIZE; i++) {
                        audioData[i] = 0;
                    }
                }
                RecognitionEngineNuance.this.logI("status: " + status);
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
                        int oldIsVoice = RecognitionEngineNuance.this.mIsVoice;
                        RecognitionEngineNuance.this.mIsVoice = RecognitionEngineNuance.this.mSamsungVoiceEngine.processNSFrame(dst, dst.length);
                        shortBuffer.position(oldPosition);
                        shortBuffer.put(dst);
                        RecognitionEngineNuance.this.logI("mIsVoice: " + RecognitionEngineNuance.this.mIsVoice);
                        if (oldIsVoice == 1 && RecognitionEngineNuance.this.mIsVoice == 0) {
                            RecognitionEngineNuance.this.stopRecognition();
                        } else if (oldIsVoice == 0 && RecognitionEngineNuance.this.mIsVoice != 1) {
                        }
                    }
                    shortBuffer.position(0);
                    shortBuffer.get(shorts);
                    ByteBuffer.wrap(audioData).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(shorts);
                    if (RecognitionEngineNuance.this.mIsTranslating) {
                        RecognitionEngineNuance.this.mSpeexEncoder.speex_bits_reset(RecognitionEngineNuance.this.mBits);
                        ByteBuffer inBuf = ByteBuffer.allocateDirect(audioData.length);
                        inBuf.put(audioData);
                        inBuf.position(0);
                        ShortBuffer sb = inBuf.asShortBuffer();
                        sb.position(0);
                        short[] in = new short[RecognitionEngineNuance.this.mFrameSize];
                        sb.get(in);
                        RecognitionEngineNuance.this.mSpeexEncoder.speex_encode_int(RecognitionEngineNuance.this.mEncoderId, in, RecognitionEngineNuance.this.mBits);
                        byte[] out = new byte[in.length * 2];
                        int len = RecognitionEngineNuance.this.mSpeexEncoder.speex_bits_write(RecognitionEngineNuance.this.mBits, out, out.length);
                        byte[] buf = new byte[len];
                        System.arraycopy(out, 0, buf, 0, len);
                        RecognitionEngineNuance.this.mNmspHandler.addAudioBuf(buf);
                        sb.clear();
                        inBuf.clear();
                    }
                    shortBuffer.clear();
                    synchronized (RecognitionEngineNuance.this.mLock) {
                        try {
                            Thread.sleep(5L);
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }
            RecognitionEngineNuance.this.logI("RecognitionThread run()--");
        }
    }

    @Override // com.voiceengine.NmspHandler.OnAsrResultListener
    public void onAsrStateChanged(int state) {
        logI("onAsrStateChanged()");
        switch (state) {
            case 0:
                logI("NmspHandler.STATE_IDLE");
                break;
            case 1:
                logI("NmspHandler.STATE_LISTENING");
                break;
            case 2:
                logI("NmspHandler.STATE_THINKING");
                notifyRecognitionStart();
                break;
        }
    }

    @Override // com.voiceengine.NmspHandler.OnAsrResultListener
    public void onAsrResult(String recognized) {
        logI("onAsrResult recognized=" + recognized);
        notifyRecognitionEnd(toValidRecognizedString(recognized));
        if (!this.mIsTranslating) {
            startRecognition();
        }
    }

    @Override // com.voiceengine.NmspHandler.OnAsrResultListener
    public void onAsrError(int errorCode) {
        logE("onAsrError()");
        if (!this.mIsTranslating) {
            startRecognition();
        }
    }
}
