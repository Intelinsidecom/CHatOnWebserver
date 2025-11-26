package com.vlingo.sdk.training;

/* loaded from: classes.dex */
public enum VLTrainerErrors {
    ERROR_NETWORK_TIMEOUT,
    ERROR_NETWORK,
    ERROR_SERVER;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static VLTrainerErrors[] valuesCustom() {
        VLTrainerErrors[] vLTrainerErrorsArrValuesCustom = values();
        int length = vLTrainerErrorsArrValuesCustom.length;
        VLTrainerErrors[] vLTrainerErrorsArr = new VLTrainerErrors[length];
        System.arraycopy(vLTrainerErrorsArrValuesCustom, 0, vLTrainerErrorsArr, 0, length);
        return vLTrainerErrorsArr;
    }
}
