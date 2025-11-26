package com.coolots.p2pmsg.model;

import java.util.List;

/* loaded from: classes.dex */
public class ReqAddConferenceMemberRep extends MsgBody {
    public static final String RESULT_FAIL = "0";
    public static final String RESULT_SUCCESS = "1";
    private int CallSessionID;
    private List<ConferenceMember> ConferenceMemberList;
    private String Result;

    public int getCallSessionID() {
        return this.CallSessionID;
    }

    public void setCallSessionID(int callSessionID) {
        this.CallSessionID = callSessionID;
    }

    public List<ConferenceMember> getConferenceMemberList() {
        return this.ConferenceMemberList;
    }

    public void setConferenceMemberList(List<ConferenceMember> conferenceMemberList) {
        this.ConferenceMemberList = conferenceMemberList;
    }

    public String getResult() {
        return this.Result;
    }

    public void setResult(String result) {
        this.Result = result;
    }
}
