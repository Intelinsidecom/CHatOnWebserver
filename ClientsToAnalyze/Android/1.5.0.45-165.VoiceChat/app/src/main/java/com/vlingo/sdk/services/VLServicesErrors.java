package com.vlingo.sdk.services;

/* loaded from: classes.dex */
public enum VLServicesErrors {
    ERROR_NETWORK_TIMEOUT,
    ERROR_NETWORK,
    ERROR_SERVER,
    ERROR_CLIENT;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static VLServicesErrors[] valuesCustom() {
        VLServicesErrors[] vLServicesErrorsArrValuesCustom = values();
        int length = vLServicesErrorsArrValuesCustom.length;
        VLServicesErrors[] vLServicesErrorsArr = new VLServicesErrors[length];
        System.arraycopy(vLServicesErrorsArrValuesCustom, 0, vLServicesErrorsArr, 0, length);
        return vLServicesErrorsArr;
    }
}
