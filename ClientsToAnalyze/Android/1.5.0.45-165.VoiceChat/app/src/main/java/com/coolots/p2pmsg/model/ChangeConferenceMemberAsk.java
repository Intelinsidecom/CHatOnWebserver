package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class ChangeConferenceMemberAsk extends MsgBody {

    @NotNull
    @Pattern(regexp = "[0-9]{24}")
    private String ConferenceNo;

    @Size(max = 100, min = 1)
    private String P2PKey;

    @NotNull
    @Valid
    @Size(min = 1)
    private List<SimpleUserInfo> OldUserInfoList = new ArrayList();

    @NotNull
    @Valid
    @Size(min = 1)
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
}
