package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class AddConferenceMemberAsk extends MsgBody {
    public static final String CONF_TYPE_VIDEO = "Y";
    public static final String CONF_TYPE_VOICE = "N";

    @NotNull
    @Pattern(regexp = "[0-9]{24}")
    private String ConferenceNo;
    private String EventID;

    @Size(max = 100, min = 1)
    private String P2PKey;

    @NotNull
    @Valid
    @Size(min = 1)
    private List<SimpleUserInfo> SimpleUserInfoList = new ArrayList();

    @Pattern(regexp = "[YN]{1}")
    private String VideoConference;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public List<SimpleUserInfo> getSimpleUserInfoList() {
        return this.SimpleUserInfoList;
    }

    public void setSimpleUserInfoList(List<SimpleUserInfo> simpleUserInfoList) {
        this.SimpleUserInfoList = simpleUserInfoList;
    }

    public String getVideoConference() {
        return this.VideoConference;
    }

    public void setVideoConference(String videoConference) {
        this.VideoConference = videoConference;
    }

    public String getP2PKey() {
        return this.P2PKey;
    }

    public void setP2PKey(String p2pKey) {
        this.P2PKey = p2pKey;
    }

    public String getEventID() {
        return this.EventID;
    }

    public void setEventID(String eventID) {
        this.EventID = eventID;
    }
}
