package com.sec.chaton.p033io.entry;

/* loaded from: classes.dex */
public class GetVersion extends Entry {
    public Boolean critical;
    public String downloadurl;
    public String key;
    public String newversion;
    public Boolean uptodate;

    @Override // com.sec.chaton.p033io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("key : " + this.key + "\n");
        sb.append("uptodate : " + this.uptodate + "\n");
        sb.append("newversion : " + this.newversion + "\n");
        sb.append("critical : " + this.critical + "\n");
        sb.append("downloadurl : " + this.downloadurl + "\n");
        return sb.toString();
    }
}
