package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class EWalletAutoChargeRep extends MsgBody {
    public static final String RESULT_FAILE = "9999";
    public static final String RESULT_SUCCESS = "0000";
    public static final String RESULT_SUCCESS_TEST = "0001";
    private String AutoChargeResult;

    public String getAutoChargeResult() {
        return this.AutoChargeResult;
    }

    public void setAutoChargeResult(String autoChargeResult) {
        this.AutoChargeResult = autoChargeResult;
    }
}
