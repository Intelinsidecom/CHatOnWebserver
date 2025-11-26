package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class RegionChangeConferenceTypeAsk extends MsgBody {

    @NotNull
    @Pattern(regexp = "[0-9]{24}")
    private String ConferenceNo;

    @NotNull
    @Pattern(regexp = "[AVS]{1}")
    private String ConferenceType;

    @Size(max = 128, min = 1)
    private String PresenterUserID;
    private long RequestUserNo;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public String getConferenceType() {
        return this.ConferenceType;
    }

    public void setConferenceType(String conferenceType) {
        this.ConferenceType = conferenceType;
    }

    public String getPresenterUserID() {
        return this.PresenterUserID;
    }

    public void setPresenterUserID(String presenterUserID) {
        this.PresenterUserID = presenterUserID;
    }

    public long getRequestUserNo() {
        return this.RequestUserNo;
    }

    public void setRequestUserNo(long requestUserNo) {
        this.RequestUserNo = requestUserNo;
    }
}
