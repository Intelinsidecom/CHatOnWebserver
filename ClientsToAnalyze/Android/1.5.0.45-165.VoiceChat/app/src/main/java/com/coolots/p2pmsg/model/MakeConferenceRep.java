package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class MakeConferenceRep extends MsgBody {

    @NotNull
    @Valid
    private ConferenceInfo ConferenceInfo;
    private String LatestVersion;

    @NotNull
    @Size(max = 100, min = 1)
    private String P2PKey;
    private String Result;

    @NotNull
    private Date StartTime;

    @NotNull
    @Size(max = 16, min = 1)
    private List<SimpleUserInfo> SimpleUserInfoList = new ArrayList();

    @NotNull
    @Valid
    @Size(min = 1)
    private List<Server> Servers = new ArrayList();
    private List<URL> DownloadUrlList = new ArrayList();
    private List<EWalletInfo> EWalletInfoList = new ArrayList();

    public ConferenceInfo getConferenceInfo() {
        return this.ConferenceInfo;
    }

    public void setConferenceInfo(ConferenceInfo conferenceInfo) {
        this.ConferenceInfo = conferenceInfo;
    }

    public Date getStartTime() {
        return this.StartTime;
    }

    public void setStartTime(Date startTime) {
        if (startTime instanceof Timestamp) {
            this.StartTime = new Date(startTime.getTime());
        } else {
            this.StartTime = startTime;
        }
    }

    public void setStartTime(String startTime) throws ParseException {
        this.StartTime = DateTimeUtil.changeFormat(startTime, "yyyy-MM-dd HH:mm:ss");
    }

    public List<SimpleUserInfo> getSimpleUserInfoList() {
        return this.SimpleUserInfoList;
    }

    public void setSimpleUserInfoList(List<SimpleUserInfo> simpleUserInfoList) {
        this.SimpleUserInfoList = simpleUserInfoList;
    }

    public String getP2PKey() {
        return this.P2PKey;
    }

    public void setP2PKey(String p2pKey) {
        this.P2PKey = p2pKey;
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

    public List<Server> getServers() {
        return this.Servers;
    }

    public void setServers(List<Server> servers) {
        this.Servers = servers;
    }

    public List<URL> getDownloadUrlList() {
        return this.DownloadUrlList;
    }

    public void setDownloadUrlList(List<URL> downloadUrlList) {
        this.DownloadUrlList = downloadUrlList;
    }

    public List<EWalletInfo> getEWalletInfoList() {
        return this.EWalletInfoList;
    }

    public void setEWalletInfoList(List<EWalletInfo> eWalletInfoList) {
        this.EWalletInfoList = eWalletInfoList;
    }
}
