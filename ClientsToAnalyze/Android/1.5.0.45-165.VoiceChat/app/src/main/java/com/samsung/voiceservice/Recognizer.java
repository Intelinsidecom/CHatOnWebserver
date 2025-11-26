package com.samsung.voiceservice;

import com.vlingo.sdk.VLSdk;
import com.vlingo.sdk.recognition.AudioSourceInfo;
import com.vlingo.sdk.recognition.VLRecognitionContext;
import com.vlingo.sdk.recognition.VLRecognitionErrors;
import com.vlingo.sdk.recognition.VLRecognitionListener;
import com.vlingo.sdk.recognition.VLRecognitionResult;
import com.vlingo.sdk.recognition.VLRecognitionStates;
import com.vlingo.sdk.recognition.VLRecognitionWarnings;

/* loaded from: classes.dex */
public class Recognizer implements VLRecognitionListener {
    private static final boolean CXT_AUTOPUNCTUATION = false;
    private static final int CXT_CURSOR_POSITION = 0;
    private static final String CXT_FIELD_CONTEXT = "Vlingo";
    private static final String CXT_FIELD_ID = "dm_main";
    private static final int CXT_MAX_AUDIO_TIME = 55000;
    private static final int CXT_NOSPEECH_ENDPOINT_TIMEOUT = 5000;
    private static final int CXT_SPEECH_ENDPOINT_TIMEOUT = 1500;
    private static final String LANGUAGE = "ko-KR";
    private static final boolean PROFANITY_FILTER_ENABLED = true;
    private BufferStream mBufferStream;
    private VLRecognitionListener mListener;
    public static boolean VLSdk_getInstance_getRecognizer = false;
    private static boolean CXT_AUTO_ENDPOINTING = false;
    private static final VLRecognitionContext.CapitalizationMode CXT_CAPITALIZATION = VLRecognitionContext.CapitalizationMode.DEFAULT;
    private static final String CXT_CURRENT_TEXT = null;

    Recognizer(VLRecognitionListener listener) {
        this.mListener = listener;
    }

    public void startBufferReco(AudioSourceInfo.SourceFormat format, String lang) {
        this.mBufferStream = BufferStream.request(format);
        AudioSourceInfo info = AudioSourceInfo.getStreamSource(this.mBufferStream, format);
        start_lang(info, lang);
    }

    private void start(AudioSourceInfo info) {
        VLRecognitionContext.Builder builder = new VLRecognitionContext.Builder(info);
        builder.language("ko-KR");
        builder.fieldID(CXT_FIELD_ID);
        builder.appInfo(CXT_FIELD_CONTEXT, null, null);
        builder.autoEndpointing(CXT_AUTO_ENDPOINTING);
        builder.maxAudioTime(55000);
        builder.autoEndPointingTimeouts(1500, 5000);
        builder.autoPunctuation(false);
        builder.capitalizationMode(CXT_CAPITALIZATION);
        builder.currentText(CXT_CURRENT_TEXT);
        builder.cursorPosition(0);
        builder.profanityFilter(true);
        VLRecognitionContext recoContext = builder.build();
        VLSdk.getInstance().getRecognizer().startRecognition(recoContext, this);
    }

    private void start_lang(AudioSourceInfo info, String lang) {
        VLRecognitionContext.Builder builder = new VLRecognitionContext.Builder(info);
        builder.language(lang);
        builder.fieldID(CXT_FIELD_ID);
        builder.appInfo(CXT_FIELD_CONTEXT, null, null);
        builder.autoEndpointing(CXT_AUTO_ENDPOINTING);
        builder.maxAudioTime(55000);
        builder.autoEndPointingTimeouts(1500, 5000);
        builder.autoPunctuation(false);
        builder.capitalizationMode(CXT_CAPITALIZATION);
        builder.currentText(CXT_CURRENT_TEXT);
        builder.cursorPosition(0);
        builder.profanityFilter(true);
        VLRecognitionContext recoContext = builder.build();
        if (!VLSdk_getInstance_getRecognizer) {
            VLSdk_getInstance_getRecognizer = true;
            try {
                VLSdk.getInstance().getRecognizer().startRecognition(recoContext, this);
            } catch (Exception e) {
            }
        }
    }

    public void stop() {
        VLSdk.getInstance().getRecognizer().stopRecognition();
        closeBufferStream();
    }

    public void cancel() {
        VLSdk.getInstance().getRecognizer().cancelRecognition();
        closeBufferStream();
    }

    private void closeBufferStream() {
        if (this.mBufferStream != null) {
            try {
                this.mBufferStream.close();
            } catch (Exception e) {
            } finally {
                this.mBufferStream = null;
            }
        }
    }

    @Override // com.vlingo.sdk.recognition.VLRecognitionListener
    public void onStateChanged(VLRecognitionStates newState) {
        if (newState == VLRecognitionStates.THINKING) {
            closeBufferStream();
        }
        this.mListener.onStateChanged(newState);
    }

    @Override // com.vlingo.sdk.recognition.VLRecognitionListener
    public void onError(VLRecognitionErrors error, String message) {
        closeBufferStream();
        this.mListener.onError(error, message);
    }

    @Override // com.vlingo.sdk.recognition.VLRecognitionListener
    public void onWarning(VLRecognitionWarnings warning, String message) {
        this.mListener.onWarning(warning, message);
    }

    @Override // com.vlingo.sdk.recognition.VLRecognitionListener
    public void onRecognitionResults(VLRecognitionResult result) {
        this.mListener.onRecognitionResults(result);
    }

    @Override // com.vlingo.sdk.recognition.VLRecognitionListener
    public void onRmsChanged(int rmsValue) {
        this.mListener.onRmsChanged(rmsValue);
    }

    @Override // com.vlingo.sdk.recognition.VLRecognitionListener
    public void onCancelled() {
        this.mListener.onCancelled();
    }
}
