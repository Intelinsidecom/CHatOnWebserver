package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class ChatOnJoinRep extends MsgBody {
    private String Result;
    private Long UserNo;

    public String getResult() {
        return this.Result;
    }

    public void setResult(String result) {
        this.Result = result;
    }

    public Long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(Long userNo) {
        this.UserNo = userNo;
    }
}
