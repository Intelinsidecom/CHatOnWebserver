package com.vlingo.sdk.tts;

/* loaded from: classes.dex */
public enum VLTextToSpeechErrors {
    ERROR_NETWORK_TIMEOUT,
    ERROR_NETWORK,
    ERROR_SERVER,
    ERROR_CLIENT;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static VLTextToSpeechErrors[] valuesCustom() {
        VLTextToSpeechErrors[] vLTextToSpeechErrorsArrValuesCustom = values();
        int length = vLTextToSpeechErrorsArrValuesCustom.length;
        VLTextToSpeechErrors[] vLTextToSpeechErrorsArr = new VLTextToSpeechErrors[length];
        System.arraycopy(vLTextToSpeechErrorsArrValuesCustom, 0, vLTextToSpeechErrorsArr, 0, length);
        return vLTextToSpeechErrorsArr;
    }
}
