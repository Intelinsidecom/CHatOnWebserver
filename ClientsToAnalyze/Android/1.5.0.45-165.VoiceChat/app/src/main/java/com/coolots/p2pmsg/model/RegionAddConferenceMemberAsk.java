package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RegionAddConferenceMemberAsk extends MsgBody {
    public static final String CONF_TYPE_VIDEO = "Y";
    public static final String CONF_TYPE_VOICE = "N";
    private String ConferenceNo;
    private String EventID;
    private String GroupCode;
    private String P2PKey;
    private String RequestUserID;
    private long RequestUserNo;
    private List<SimpleUserInfo> SimpleUserInfoList = new ArrayList();
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

    public String getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(String groupCode) {
        this.GroupCode = groupCode;
    }

    public String getRequestUserID() {
        return this.RequestUserID;
    }

    public void setRequestUserID(String requestUserID) {
        this.RequestUserID = requestUserID;
    }

    public long getRequestUserNo() {
        return this.RequestUserNo;
    }

    public void setRequestUserNo(long requestUserNo) {
        this.RequestUserNo = requestUserNo;
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
