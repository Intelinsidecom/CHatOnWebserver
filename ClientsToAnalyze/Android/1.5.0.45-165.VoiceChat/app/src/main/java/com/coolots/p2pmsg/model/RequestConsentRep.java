package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RequestConsentRep extends MsgBody {
    private boolean accept;
    private int callSessionID;
    private boolean canceledByTimer;
    private String conferenceNo;
    private int consentType;
    private int option;
    private int requestKey;
    private String requesterID;

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

    public String getRequesterID() {
        return this.requesterID;
    }

    public void setRequesterID(String requesterID) {
        this.requesterID = requesterID;
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

    public boolean isAccept() {
        return this.accept;
    }

    public boolean getAccept() {
        return this.accept;
    }

    public void setAccept(boolean isAccept) {
        this.accept = isAccept;
    }

    public boolean isCanceledByTimer() {
        return this.canceledByTimer;
    }

    public boolean getCanceledByTimer() {
        return this.canceledByTimer;
    }

    public void setCanceledByTimer(boolean isCanceledByTimer) {
        this.canceledByTimer = isCanceledByTimer;
    }

    public int getRequestKey() {
        return this.requestKey;
    }

    public void setRequestKey(int requestKey) {
        this.requestKey = requestKey;
    }
}
