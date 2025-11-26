package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class MuteConferenceRep extends MsgBody {
    private int Result;
    public static int RESULT_SUCCESS = 1;
    public static int RESULT_FAIL = 0;

    public int getResult() {
        return this.Result;
    }

    public void setResult(int result) {
        this.Result = result;
    }
}
