package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RegionChangeConferenceMemberAsk extends MsgBody {
    private String ConferenceNo;
    private String GroupCode;
    private String P2PKey;
    private String RequestUserID;
    private long RequestUserNo;
    private List<SimpleUserInfo> OldUserInfoList = new ArrayList();
    private List<SimpleUserInfo> NewUserInfoList = new ArrayList();

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public List<SimpleUserInfo> getOldUserInfoList() {
        return this.OldUserInfoList;
    }

    public void setOldUserInfoList(List<SimpleUserInfo> oldUserInfoList) {
        this.OldUserInfoList = oldUserInfoList;
    }

    public List<SimpleUserInfo> getNewUserInfoList() {
        return this.NewUserInfoList;
    }

    public void setNewUserInfoList(List<SimpleUserInfo> newUserInfoList) {
        this.NewUserInfoList = newUserInfoList;
    }

    public String getP2PKey() {
        return this.P2PKey;
    }

    public void setP2PKey(String p2pKey) {
        this.P2PKey = p2pKey;
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

    public String getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(String groupCode) {
        this.GroupCode = groupCode;
    }
}
