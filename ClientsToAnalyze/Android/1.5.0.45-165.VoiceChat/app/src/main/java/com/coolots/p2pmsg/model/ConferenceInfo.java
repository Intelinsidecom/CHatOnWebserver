package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.Domain;
import com.coolots.p2pmsg.validator.IpOrDomain;
import com.coolots.p2pmsg.validator.SIPNo;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class ConferenceInfo {

    @NotNull
    @Pattern(regexp = "[0-9]{24}")
    private String ConferenceNo;

    @NotNull
    @Pattern(regexp = "[AVS]{1}")
    private String ConferenceType;

    @NotNull
    @Domain
    private String DomainAddr;

    @SIPNo
    @NotNull
    private String MCUPhoneNo;

    @NotNull
    @Size(max = 128, min = 0)
    private String Password;

    @SIPNo
    @NotNull
    private String PhoneNo;

    @IpOrDomain
    @NotNull
    private String ProxyAddr;

    @Valid
    private List<SipProxyInfo> SipProxyInfoList = new ArrayList();

    @Pattern(regexp = "[YN]{1}")
    private String VideoConference;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public String getDomainAddr() {
        return this.DomainAddr;
    }

    public void setDomainAddr(String domainAddr) {
        this.DomainAddr = domainAddr;
    }

    public String getProxyAddr() {
        return this.ProxyAddr;
    }

    public void setProxyAddr(String proxyAddr) {
        this.ProxyAddr = proxyAddr;
    }

    public String getMCUPhoneNo() {
        return this.MCUPhoneNo;
    }

    public void setMCUPhoneNo(String phoneNo) {
        this.MCUPhoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return this.PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.PhoneNo = phoneNo;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getVideoConference() {
        return this.VideoConference;
    }

    public void setVideoConference(String videoConference) {
        this.VideoConference = videoConference;
    }

    public List<SipProxyInfo> getSipProxyInfoList() {
        return this.SipProxyInfoList;
    }

    public void setSipProxyInfoList(List<SipProxyInfo> sipProxyInfoList) {
        this.SipProxyInfoList = sipProxyInfoList;
    }

    public String getConferenceType() {
        return this.ConferenceType;
    }

    public void setConferenceType(String conferenceType) {
        this.ConferenceType = conferenceType;
    }
}
