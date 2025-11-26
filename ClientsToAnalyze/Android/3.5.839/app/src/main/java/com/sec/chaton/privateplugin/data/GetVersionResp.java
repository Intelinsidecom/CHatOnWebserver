package com.sec.chaton.privateplugin.data;

/* loaded from: classes.dex */
public class GetVersionResp {
    private Boolean critical;
    private String downloadurl;
    private String key;
    private String newversion;
    private Boolean uptodate;

    public String getKey() {
        return this.key;
    }

    public Boolean getUptodate() {
        return this.uptodate;
    }

    public String getNewversion() {
        return this.newversion;
    }

    public Boolean getCritical() {
        return this.critical;
    }

    public String getDownloadurl() {
        return this.downloadurl;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setUptodate(Boolean bool) {
        this.uptodate = bool;
    }

    public void setNewversion(String str) {
        this.newversion = str;
    }

    public void setCritical(Boolean bool) {
        this.critical = bool;
    }

    public void setDownloadurl(String str) {
        this.downloadurl = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GetVersionResp [key=").append(this.key).append(", uptodate=").append(this.uptodate).append(", newversion=").append(this.newversion).append(", critical=").append(this.critical).append(", downloadurl=").append(this.downloadurl).append("]");
        return sb.toString();
    }
}
