package com.vlingo.sdk.internal.recognizer;

import com.vlingo.sdk.internal.recognizer.results.SRRecognitionResponse;

/* loaded from: classes.dex */
public interface RecognizerListener {

    public enum RecognizerError {
        FAIL_CONNECT,
        TIMEOUT,
        READER_ERROR,
        TOO_SHORT,
        NO_RESULTS,
        NO_SPEECH;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static RecognizerError[] valuesCustom() {
            RecognizerError[] recognizerErrorArrValuesCustom = values();
            int length = recognizerErrorArrValuesCustom.length;
            RecognizerError[] recognizerErrorArr = new RecognizerError[length];
            System.arraycopy(recognizerErrorArrValuesCustom, 0, recognizerErrorArr, 0, length);
            return recognizerErrorArr;
        }
    }

    public enum RecognizerState {
        CONNECTING,
        LISTENING,
        RMS_CHANGED,
        SENDING,
        THINKING,
        RECEIVING,
        RESULT;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static RecognizerState[] valuesCustom() {
            RecognizerState[] recognizerStateArrValuesCustom = values();
            int length = recognizerStateArrValuesCustom.length;
            RecognizerState[] recognizerStateArr = new RecognizerState[length];
            System.arraycopy(recognizerStateArrValuesCustom, 0, recognizerStateArr, 0, length);
            return recognizerStateArr;
        }
    }

    void onRecognitionResponse(SRRecognitionResponse sRRecognitionResponse);

    void onRecognizerError(RecognizerError recognizerError, String str);

    void onRecognizerStateChanged(RecognizerState recognizerState, Object obj);
}
