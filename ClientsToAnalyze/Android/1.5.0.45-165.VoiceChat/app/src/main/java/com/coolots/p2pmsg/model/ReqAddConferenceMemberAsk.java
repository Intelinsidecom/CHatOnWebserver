package com.coolots.p2pmsg.model;

import java.util.List;

/* loaded from: classes.dex */
public class ReqAddConferenceMemberAsk extends MsgBody {
    private int CallSessionID;
    private List<ConferenceMember> ConferenceMemberList;
    private String RequestID;

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

    public String getRequestID() {
        return this.RequestID;
    }

    public void setRequestID(String requestID) {
        this.RequestID = requestID;
    }
}
