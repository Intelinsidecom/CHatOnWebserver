package com.csli.eztalky;

/* loaded from: classes.dex */
public enum SampleRate {
    F_8k(80),
    F_16k(160);

    private final int value;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static SampleRate[] valuesCustom() {
        SampleRate[] sampleRateArrValuesCustom = values();
        int length = sampleRateArrValuesCustom.length;
        SampleRate[] sampleRateArr = new SampleRate[length];
        System.arraycopy(sampleRateArrValuesCustom, 0, sampleRateArr, 0, length);
        return sampleRateArr;
    }

    SampleRate(int rate) {
        this.value = rate;
    }

    public int getValue() {
        return this.value;
    }
}
