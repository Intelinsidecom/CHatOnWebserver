package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class NotifyConsentAsk extends MsgBody {
    private boolean accept;
    private int callSessionID;
    private boolean canceledByTimer;
    private String conferenceNo;
    private int consentType;
    private int option;
    private String rejectUserID;
    private int requestKey;

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

    public String getRejectUserID() {
        return this.rejectUserID;
    }

    public void setRejectUserID(String rejectUserID) {
        this.rejectUserID = rejectUserID;
    }
}
