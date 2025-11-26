package com.samsung.voiceservice;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.coolots.chaton.setting.data.ChatONHideMeImgData;
import com.coolots.sso.util.ChatONVAPII;
import com.samsung.voiceshell.VoiceEngine;
import com.samsung.voiceshell.VoiceEngineWrapper;
import com.vlingo.sdk.VLSdk;
import com.vlingo.sdk.recognition.AudioSourceInfo;
import com.vlingo.sdk.recognition.VLRecognitionErrors;
import com.vlingo.sdk.recognition.VLRecognitionListener;
import com.vlingo.sdk.recognition.VLRecognitionResult;
import com.vlingo.sdk.recognition.VLRecognitionStates;
import com.vlingo.sdk.recognition.VLRecognitionWarnings;
import com.voiceengine.SamsungAudioEngine;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class SVoiceVoIPASR {
    private static final String APP_CHANNEL = "Preinstall Free";
    private static final String APP_ID = "com.samsung.android.midasumpc";
    private static final String APP_NAME = "SamsungQ2";
    private static final String APP_VERSION = "1.0.0";
    private static final boolean LOCATION_ENABLED = true;
    private static final String RECO_SERVER_URI = "http://samsungdemoasr.vlingo.com";
    private static final String TTS_SERVER_URI = "http://samsungdemoasr.vlingo.com";
    private FileOutputStream mFileOS;
    private boolean mIsTranslating;
    private boolean mIsTranslationThreadRunning;
    private int mIsVoice;
    private OnAsrResultListener mOnAsrResultListener;
    private RecognitionThread mRecognitionThread;
    private Recognizer mRecognizer;
    private VoiceEngine mSamsungVoiceEngine;
    private VLSdk mSdk;
    private VLRecognitionListener mRecoListener = new VLRecognitionListenerImpl(this, null);
    public int mBuffer_size = 6400;
    private String mASRLanguage = "en-US";
    private int RECORD_BUFFER_SIZE = ChatONHideMeImgData.IMAGE_DEFAULT_HEIGHT;
    private boolean mIsFileDump = true;
    private Object mLock = new Object();

    public interface OnAsrResultListener {
        void onAsrError(String str);

        void onAsrIsVoice(int i);

        void onAsrResult(String str);
    }

    public SVoiceVoIPASR(Context context) {
        Log.e("SVOICE", "create()");
        try {
            this.mSdk = VLSdk.create(context, APP_ID, APP_NAME, APP_VERSION, APP_CHANNEL, true, "http://samsungdemoasr.vlingo.com", "http://samsungdemoasr.vlingo.com", null);
            this.mRecognizer = new Recognizer(this.mRecoListener);
            this.mSamsungVoiceEngine = VoiceEngineWrapper.getInstance();
            this.mSamsungVoiceEngine.initializeNS();
        } catch (Exception e) {
        }
    }

    public void SVoiceVoIPASRSetListener(OnAsrResultListener listener) {
        this.mOnAsrResultListener = listener;
    }

    public void startRecognition(String language) {
        Log.e("SVOICE", "startRecognition: " + language);
        this.mASRLanguage = language;
        if (this.mIsFileDump) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
            File file = new File(Environment.getExternalStorageDirectory() + "/input_data_" + sdf.format(date).toString() + ".raw");
            if (file.exists()) {
                file.delete();
            }
            if (this.mFileOS == null) {
                try {
                    this.mFileOS = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                }
            }
        }
        if (this.mRecognitionThread == null) {
            this.mRecognitionThread = new RecognitionThread(this, null);
            this.mIsTranslationThreadRunning = true;
            this.mRecognitionThread.start();
        }
        this.mRecognizer.startBufferReco(AudioSourceInfo.SourceFormat.PCM_16KHZ_16BIT, this.mASRLanguage);
        this.mIsTranslating = true;
    }

    public void stopRecognition() throws IOException {
        Log.e("SVOICE", "stopRecognition");
        this.mIsTranslating = false;
        if (this.mRecognitionThread != null) {
            this.mIsTranslationThreadRunning = false;
        }
        this.mRecognitionThread = null;
        Recognizer.VLSdk_getInstance_getRecognizer = false;
        if (this.mIsFileDump && this.mFileOS != null) {
            try {
                this.mFileOS.close();
                this.mFileOS = null;
            } catch (IOException e) {
            }
        }
    }

    private class RecognitionThread extends Thread {
        private RecognitionThread() {
        }

        /* synthetic */ RecognitionThread(SVoiceVoIPASR sVoiceVoIPASR, RecognitionThread recognitionThread) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IOException {
            boolean bSpeech = false;
            boolean epd = false;
            while (SVoiceVoIPASR.this.mIsTranslationThreadRunning) {
                byte[] audioData = new byte[SVoiceVoIPASR.this.RECORD_BUFFER_SIZE];
                int status = SamsungAudioEngine.SAE_GetTxPCM(audioData, SVoiceVoIPASR.this.RECORD_BUFFER_SIZE);
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
                        int oldIsVoice = SVoiceVoIPASR.this.mIsVoice;
                        SVoiceVoIPASR.this.mIsVoice = SVoiceVoIPASR.this.mSamsungVoiceEngine.processNSFrame(dst, dst.length);
                        shortBuffer.position(oldPosition);
                        shortBuffer.put(dst);
                        if (SVoiceVoIPASR.this.mOnAsrResultListener != null) {
                            SVoiceVoIPASR.this.mOnAsrResultListener.onAsrIsVoice(SVoiceVoIPASR.this.mIsVoice);
                        } else {
                            SVoiceVoIPASR.this.mOnAsrResultListener.onAsrIsVoice(0);
                        }
                        if (oldIsVoice == 1 && SVoiceVoIPASR.this.mIsVoice == 0) {
                            Log.e("elfin007", "onerror error Detect an EPD");
                            epd = true;
                        } else if (oldIsVoice == 0 && SVoiceVoIPASR.this.mIsVoice == 1) {
                            Log.e("elfin007", "onerror error Start a speech");
                            bSpeech = true;
                        }
                    }
                    shortBuffer.position(0);
                    shortBuffer.get(shorts);
                    ByteBuffer.wrap(audioData).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(shorts);
                    if (!epd) {
                        if (SVoiceVoIPASR.this.mIsTranslating && bSpeech) {
                            Log.d("", "audioData.length = " + audioData.length);
                            BufferStream.addAudioBuf(audioData, SVoiceVoIPASR.this.mBuffer_size, false);
                            try {
                                if (SVoiceVoIPASR.this.mIsFileDump && SVoiceVoIPASR.this.mFileOS != null) {
                                    SVoiceVoIPASR.this.mFileOS.write(audioData);
                                }
                            } catch (IOException e) {
                            }
                        }
                    } else {
                        BufferStream.addAudioBuf(audioData, SVoiceVoIPASR.this.mBuffer_size, true);
                        SVoiceVoIPASR.this.stopRecognition();
                    }
                    synchronized (SVoiceVoIPASR.this.mLock) {
                        try {
                            Thread.sleep(5L);
                        } catch (InterruptedException e2) {
                        }
                    }
                }
            }
        }
    }

    private class VLRecognitionListenerImpl implements VLRecognitionListener {
        private VLRecognitionListenerImpl() {
        }

        /* synthetic */ VLRecognitionListenerImpl(SVoiceVoIPASR sVoiceVoIPASR, VLRecognitionListenerImpl vLRecognitionListenerImpl) {
            this();
        }

        @Override // com.vlingo.sdk.recognition.VLRecognitionListener
        public void onStateChanged(VLRecognitionStates newState) {
        }

        @Override // com.vlingo.sdk.recognition.VLRecognitionListener
        public void onError(VLRecognitionErrors error, String message) {
            String str = String.valueOf(error.name()) + " - " + message;
            Log.e("SVOICE", "onError() " + error.name() + " - " + message);
            if (message != null) {
                SVoiceVoIPASR.this.mOnAsrResultListener.onAsrError(message);
            } else {
                SVoiceVoIPASR.this.mOnAsrResultListener.onAsrError("");
            }
            SVoiceVoIPASR.this.startRecognition(SVoiceVoIPASR.this.mASRLanguage);
        }

        @Override // com.vlingo.sdk.recognition.VLRecognitionListener
        public void onWarning(VLRecognitionWarnings warning, String message) {
            Log.e("SVOICE", "onWarning");
        }

        @Override // com.vlingo.sdk.recognition.VLRecognitionListener
        public void onRecognitionResults(VLRecognitionResult result) {
            String resultStr = result.getResultString();
            Log.e("SVOICE", "onResults() " + resultStr);
            Log.e("onRecognitionResults", "onerror error Result string :" + resultStr + ChatONVAPII.USERID_DELEMETER);
            if (resultStr == null) {
                SVoiceVoIPASR.this.mOnAsrResultListener.onAsrResult("");
                return;
            }
            if (!resultStr.equals("")) {
            }
            if (SVoiceVoIPASR.this.mOnAsrResultListener != null) {
                SVoiceVoIPASR.this.mOnAsrResultListener.onAsrResult(resultStr);
            }
        }

        @Override // com.vlingo.sdk.recognition.VLRecognitionListener
        public void onRmsChanged(int rmsValue) {
            Log.w("SVOICE", "onChanged");
        }

        @Override // com.vlingo.sdk.recognition.VLRecognitionListener
        public void onCancelled() {
            Log.e("SVOICE", "onCalcelled");
        }
    }
}
