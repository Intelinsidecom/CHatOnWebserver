package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.Ip;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class EnterRelayRegisterRep extends MsgBody {
    private List<URL> DownloadUrlList = new ArrayList();
    private int ErrorCode;
    private String LatestVersion;

    @Ip
    private String PublicIP;

    @Max(65535)
    @Min(0)
    private Integer PublicPort;

    @NotNull
    @Size(max = 100, min = 1)
    private String PushKey;
    private String Result;

    public String getPushKey() {
        return this.PushKey;
    }

    public void setPushKey(String pushKey) {
        this.PushKey = pushKey;
    }

    public String getPublicIP() {
        return this.PublicIP;
    }

    public void setPublicIP(String publicIP) {
        this.PublicIP = publicIP;
    }

    public Integer getPublicPort() {
        return this.PublicPort;
    }

    public void setPublicPort(Integer publicPort) {
        this.PublicPort = publicPort;
    }

    public int getErrorCode() {
        return this.ErrorCode;
    }

    public void setErrorCode(int errorCode) {
        this.ErrorCode = errorCode;
    }

    public String getResult() {
        return this.Result;
    }

    public void setResult(String result) {
        this.Result = result;
    }

    public String getLatestVersion() {
        return this.LatestVersion;
    }

    public void setLatestVersion(String latestVersion) {
        this.LatestVersion = latestVersion;
    }

    public List<URL> getDownloadUrlList() {
        return this.DownloadUrlList;
    }

    public void setDownloadUrlList(List<URL> downloadUrlList) {
        this.DownloadUrlList = downloadUrlList;
    }
}
