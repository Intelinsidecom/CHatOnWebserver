package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class ProposeConsentAsk extends MsgBody {
    public static final int OPTION_MEMORIAL_CAPTURE = 1;
    public static final int OPTION_MEMORIAL_RECORD = 2;
    public static final int OPTION_SWITCHCALL_VIDEOTOVOICE = 1;
    public static final int OPTION_SWITCHCALL_VOICETOVIDEO = 2;
    public static final int TYPE_MEMORIAL = 4;
    public static final int TYPE_SHARE_CAMERA = 2;
    public static final int TYPE_SHARE_SCREEN = 3;
    public static final int TYPE_SWITCH_CALL = 1;
    private int callSessionID;
    private String conferenceNo;
    private int consentType;
    private int option;
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
}
