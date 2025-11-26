package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RequestCallTypeChangeAsk extends MsgBody {
    public static final int MEDIA_TYPE_CAPTURE = 11;
    public static final int MEDIA_TYPE_RECORDING = 10;
    public static final int MEDIA_TYPE_SCREEN_SHARE = 13;
    public static final int MEDIA_TYPE_SHARE_VIEW = 12;
    public static final int MEDIA_TYPE_VIDEO = 1;
    public static final int MEDIA_TYPE_VOICE = 0;
    private int CallSessionID;
    private String ConferenceNo;
    private int MediaType;
    private String UserID;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public int getMediaType() {
        return this.MediaType;
    }

    public void setMediaType(int mediaType) {
        this.MediaType = mediaType;
    }

    public String getUserID() {
        return this.UserID;
    }

    public void setUserID(String userID) {
        this.UserID = userID;
    }

    public int getCallSessionID() {
        return this.CallSessionID;
    }

    public void setCallSessionID(int callSessionID) {
        this.CallSessionID = callSessionID;
    }
}
