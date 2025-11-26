package com.vlingo.sdk.recognition;

/* loaded from: classes.dex */
public interface VLRecognitionListener {
    void onCancelled();

    void onError(VLRecognitionErrors vLRecognitionErrors, String str);

    void onRecognitionResults(VLRecognitionResult vLRecognitionResult);

    void onRmsChanged(int i);

    void onStateChanged(VLRecognitionStates vLRecognitionStates);

    void onWarning(VLRecognitionWarnings vLRecognitionWarnings, String str);
}
