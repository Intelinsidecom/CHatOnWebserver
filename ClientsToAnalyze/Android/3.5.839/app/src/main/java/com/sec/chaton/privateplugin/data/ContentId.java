package com.sec.chaton.privateplugin.data;

/* loaded from: classes.dex */
public class ContentId {
    private String ctid;

    public String getContentId() {
        return this.ctid;
    }

    public void setContentId(String str) {
        this.ctid = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContentId [ctid=").append(this.ctid).append("]");
        return sb.toString();
    }
}
