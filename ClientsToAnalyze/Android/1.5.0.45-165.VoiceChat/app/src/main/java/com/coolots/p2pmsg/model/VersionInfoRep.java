package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class VersionInfoRep extends MsgBody {
    public static final String CRITICAL_UPDATE = "3";
    public static final String MINOR_UPDATE = "2";
    public static final String NORMAL_UPDATE = "1";
    public static final String SAME_VERSION = "0";
    private List<URL> DownloadUrlList = new ArrayList();
    private String LatestVersion;
    private String Result;
    private String UpdateUrl;

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

    public String getUpdateUrl() {
        return this.UpdateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.UpdateUrl = updateUrl;
    }

    public List<URL> getDownloadUrlList() {
        return this.DownloadUrlList;
    }

    public void setDownloadUrlList(List<URL> downloadUrlList) {
        this.DownloadUrlList = downloadUrlList;
    }
}
