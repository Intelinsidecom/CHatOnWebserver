package com.sec.chaton.p035io.entry;

/* loaded from: classes.dex */
public class GetVersionNotice extends Entry {
    public String UTCtimestamp;
    public Boolean critical;
    public String disclaimerUID;
    public String downloadurl;
    public String mcc;
    public String model;
    public Boolean needPopup;
    public String newversion;
    public Integer notice;
    public String osversion;
    public String platform;
    public String samsungappsurl;
    public Boolean uptodate;

    @Override // com.sec.chaton.p035io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("platform : " + this.platform + "\n");
        sb.append("osversion : " + this.osversion + "\n");
        sb.append("model : " + this.model + "\n");
        sb.append("newversion : " + this.newversion + "\n");
        sb.append("uptodate : " + this.uptodate + "\n");
        sb.append("critical : " + this.critical + "\n");
        sb.append("downloadurl : " + this.downloadurl + "\n");
        sb.append("samsungappsurl : " + this.samsungappsurl + "\n");
        sb.append("disclaimerUID : " + this.disclaimerUID + "\n");
        sb.append("mcc : " + this.mcc + "\n");
        sb.append("needPopup : " + this.needPopup + "\n");
        sb.append("notice : " + this.notice + "\n");
        sb.append("UTCtimestamp : " + this.UTCtimestamp + "\n");
        return sb.toString();
    }
}
