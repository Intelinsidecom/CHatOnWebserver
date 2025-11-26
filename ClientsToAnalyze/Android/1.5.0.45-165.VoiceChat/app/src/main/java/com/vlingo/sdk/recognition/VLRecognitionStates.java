package com.vlingo.sdk.recognition;

/* loaded from: classes.dex */
public enum VLRecognitionStates {
    GETTING_READY,
    CONNECTING,
    LISTENING,
    THINKING;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static VLRecognitionStates[] valuesCustom() {
        VLRecognitionStates[] vLRecognitionStatesArrValuesCustom = values();
        int length = vLRecognitionStatesArrValuesCustom.length;
        VLRecognitionStates[] vLRecognitionStatesArr = new VLRecognitionStates[length];
        System.arraycopy(vLRecognitionStatesArrValuesCustom, 0, vLRecognitionStatesArr, 0, length);
        return vLRecognitionStatesArr;
    }
}
