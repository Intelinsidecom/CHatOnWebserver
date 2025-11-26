package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class LoginRep extends MsgBody {

    @Size(max = 24, min = 24)
    private String CipherKey;

    @Size(max = 16, min = 16)
    private String SessionID;

    @Min(1)
    private long UserNo;
    private List<EWalletInfo> EWalletInfoList = new ArrayList();
    private List<PaidSvcPolicyInfo> PaidSvcPolicyList = new ArrayList();
    private List<ConfLimitPolicyInfo> ConfLimitPolicyList = new ArrayList();

    public long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(long userNo) {
        this.UserNo = userNo;
    }

    public String getCipherKey() {
        return this.CipherKey;
    }

    public void setCipherKey(String cipherKey) {
        this.CipherKey = cipherKey;
    }

    public String getSessionID() {
        return this.SessionID;
    }

    public void setSessionID(String sessionID) {
        this.SessionID = sessionID;
    }

    public List<EWalletInfo> getEWalletInfoList() {
        return this.EWalletInfoList;
    }

    public void setEWalletInfoList(List<EWalletInfo> eWalletInfoList) {
        this.EWalletInfoList = eWalletInfoList;
    }

    public List<PaidSvcPolicyInfo> getPaidSvcPolicyList() {
        return this.PaidSvcPolicyList;
    }

    public void setPaidSvcPolicyList(List<PaidSvcPolicyInfo> paidSvcPolicyList) {
        this.PaidSvcPolicyList = paidSvcPolicyList;
    }

    public List<ConfLimitPolicyInfo> getConfLimitPolicyList() {
        return this.ConfLimitPolicyList;
    }

    public void setConfLimitPolicyList(List<ConfLimitPolicyInfo> confLimitPolicyList) {
        this.ConfLimitPolicyList = confLimitPolicyList;
    }
}
