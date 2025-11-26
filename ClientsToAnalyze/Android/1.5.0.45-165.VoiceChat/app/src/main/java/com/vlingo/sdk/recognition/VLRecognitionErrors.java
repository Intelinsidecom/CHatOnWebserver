package com.vlingo.sdk.recognition;

/* loaded from: classes.dex */
public enum VLRecognitionErrors {
    ERROR_NETWORK_TIMEOUT,
    ERROR_NETWORK,
    ERROR_AUDIO,
    ERROR_SERVER,
    ERROR_CLIENT,
    ERROR_SPEECH_TIMEOUT,
    ERROR_NO_MATCH,
    ERROR_RECOGNIZER_BUSY,
    ERROR_INSUFFICENT_PERMISSIONS;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static VLRecognitionErrors[] valuesCustom() {
        VLRecognitionErrors[] vLRecognitionErrorsArrValuesCustom = values();
        int length = vLRecognitionErrorsArrValuesCustom.length;
        VLRecognitionErrors[] vLRecognitionErrorsArr = new VLRecognitionErrors[length];
        System.arraycopy(vLRecognitionErrorsArrValuesCustom, 0, vLRecognitionErrorsArr, 0, length);
        return vLRecognitionErrorsArr;
    }
}
