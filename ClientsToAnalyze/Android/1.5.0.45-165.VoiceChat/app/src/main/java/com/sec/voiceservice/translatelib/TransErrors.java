package com.sec.voiceservice.translatelib;

import com.vlingo.sdk.internal.Strings;

/* loaded from: classes.dex */
public enum TransErrors {
    ERROR_Account("1001", "Samsung account error"),
    ERROR_Language("1002", "Language error"),
    ERROR_Broadcast("1003", "BroadcastReceiver error"),
    ERROR_Network("1003", Strings.client_core_network_error),
    ERROR_Server("1004", "Server error"),
    ERROR_IO("1005", "IO error"),
    ERROR_Parameter("1006", "Parameter error"),
    ERROR_Authen("1007", "Authen error"),
    ERROR_China("1007", "China Authen error"),
    ERROR_BadToken("1007", "Bad access token"),
    ERROR_Json("1009", "JSON format error"),
    ERROR_Protocol("1009", "Protocal error"),
    ERROR_Sentence("1009", "SentenceBreaker error"),
    ERROR_FileAuthen("1009", "FileAuthen error"),
    ERROR_Exception("1009", "Exception error");

    private String code;
    private String desc;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static TransErrors[] valuesCustom() {
        TransErrors[] transErrorsArrValuesCustom = values();
        int length = transErrorsArrValuesCustom.length;
        TransErrors[] transErrorsArr = new TransErrors[length];
        System.arraycopy(transErrorsArrValuesCustom, 0, transErrorsArr, 0, length);
        return transErrorsArr;
    }

    TransErrors(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
