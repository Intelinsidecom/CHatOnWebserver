package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class AddConferenceMemberRep extends MsgBody {

    @NotNull
    @Pattern(regexp = "[0-9]{24}")
    private String ConferenceNo;

    @NotNull
    @Valid
    @Size(max = 1, min = 1)
    private List<SimpleUserInfo> SimpleUserInfoList = new ArrayList();
    private List<EWalletInfo> EWalletInfoList = new ArrayList();

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

    public List<EWalletInfo> getEWalletInfoList() {
        return this.EWalletInfoList;
    }

    public void setEWalletInfoList(List<EWalletInfo> eWalletInfoList) {
        this.EWalletInfoList = eWalletInfoList;
    }
}
