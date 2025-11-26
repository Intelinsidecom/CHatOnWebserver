package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class ProposeConsentRep extends MsgBody {
    private int callSessionID;
    private String conferenceNo;
    private int consentType;
    private int option;
    private int requestKey;
    private boolean requestResult;

    public int getCallSessionID() {
        return this.callSessionID;
    }

    public void setCallSessionID(int callSessionID) {
        this.callSessionID = callSessionID;
    }

    public String getConferenceNo() {
        return this.conferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.conferenceNo = conferenceNo;
    }

    public int getRequestKey() {
        return this.requestKey;
    }

    public void setRequestKey(int requestKey) {
        this.requestKey = requestKey;
    }

    public int getConsentType() {
        return this.consentType;
    }

    public void setConsentType(int consentType) {
        this.consentType = consentType;
    }

    public int getOption() {
        return this.option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public boolean isRequestResult() {
        return this.requestResult;
    }

    public boolean getRequestResult() {
        return this.requestResult;
    }

    public void setRequestResult(boolean requestResult) {
        this.requestResult = requestResult;
    }
}
