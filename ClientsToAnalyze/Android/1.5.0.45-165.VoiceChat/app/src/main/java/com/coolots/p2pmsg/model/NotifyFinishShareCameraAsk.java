package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class NotifyFinishShareCameraAsk extends MsgBody {
    public static final int END_REASON_ABNORMAL_END = 1;
    public static final int END_REASON_START_SEMINAR_FOR_DOC_SHARE = 1000;
    public static final int END_REASON_USER_ACTION = 0;
    private int callSessionID;
    private String conferenceNo;
    private int endReason;

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

    public int getEndReason() {
        return this.endReason;
    }

    public void setEndReason(int endReason) {
        this.endReason = endReason;
    }
}
