package com.sec.chaton.p028io.entry;

/* loaded from: classes.dex */
public class GetVersion2 extends Entry {
    public Boolean critical;
    public String downloadurl;
    public String model;
    public String newversion;
    public String osversion;
    public String platform;
    public Boolean uptodate;

    @Override // com.sec.chaton.p028io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("platform : " + this.platform + "\n");
        sb.append("osversion : " + this.osversion + "\n");
        sb.append("uptodate : " + this.uptodate + "\n");
        sb.append("newversion : " + this.newversion + "\n");
        sb.append("model : " + this.model + "\n");
        sb.append("critical : " + this.critical + "\n");
        sb.append("downloadurl : " + this.downloadurl + "\n");
        return sb.toString();
    }
}
