package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class PhoneNoAuthRep extends MsgBody {
    public static final String AUTH_RESULT_EXPIRE = "0";
    public static final String AUTH_RESULT_FAIL = "-1";
    public static final String AUTH_RESULT_NONE = "-2";
    public static final String AUTH_RESULT_SUCCESS = "1";
    private String Result;

    public String getResult() {
        return this.Result;
    }

    public void setResult(String result) {
        this.Result = result;
    }
}
