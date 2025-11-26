package com.vlingo.sdk.recognition;

/* loaded from: classes.dex */
public enum VLRecognitionWarnings {
    WARNING_SERVER,
    WARNING_NOTHING_RECOGNIZED;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static VLRecognitionWarnings[] valuesCustom() {
        VLRecognitionWarnings[] vLRecognitionWarningsArrValuesCustom = values();
        int length = vLRecognitionWarningsArrValuesCustom.length;
        VLRecognitionWarnings[] vLRecognitionWarningsArr = new VLRecognitionWarnings[length];
        System.arraycopy(vLRecognitionWarningsArrValuesCustom, 0, vLRecognitionWarningsArr, 0, length);
        return vLRecognitionWarningsArr;
    }
}
