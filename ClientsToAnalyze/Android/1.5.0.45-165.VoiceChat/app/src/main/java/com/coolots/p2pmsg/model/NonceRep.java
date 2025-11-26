package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class NonceRep extends MsgBody {

    @Deprecated
    @Size(max = 16)
    private String AppVersion;

    @NotNull
    @Size(max = 10, min = 10)
    private String Nonce;

    @NotNull
    private Date NonceValidateTime;
    private List<EWalletInfo> EWalletInfoList = new ArrayList();
    private List<PaidSvcPolicyInfo> PaidSvcPolicyList = new ArrayList();
    private List<ConfLimitPolicyInfo> ConfLimitPolicyList = new ArrayList();

    public String getNonce() {
        return this.Nonce;
    }

    public void setNonce(String nonce) {
        this.Nonce = nonce;
    }

    public Date getNonceValidateTime() {
        return this.NonceValidateTime;
    }

    public void setNonceValidateTime(Date nonceValidateTime) {
        this.NonceValidateTime = nonceValidateTime;
    }

    public void setNonceValidateTime(String nonceValidateTime) throws ParseException {
        setNonceValidateTime(DateTimeUtil.changeFormat(nonceValidateTime, "yyyy-MM-dd HH:mm:ss"));
    }

    @Deprecated
    public String getAppVersion() {
        return this.AppVersion;
    }

    @Deprecated
    public void setAppVersion(String appVersion) {
        this.AppVersion = appVersion;
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
