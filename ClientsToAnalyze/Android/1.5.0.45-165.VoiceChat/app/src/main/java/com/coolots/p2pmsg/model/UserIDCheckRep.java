package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class UserIDCheckRep extends MsgBody {
    public static final String RESULT_FAIL = "0";
    public static final String RESULT_SUCCESS = "1";
    private String Result;

    public String getResult() {
        return this.Result;
    }

    public void setResult(String result) {
        this.Result = result;
    }
}
