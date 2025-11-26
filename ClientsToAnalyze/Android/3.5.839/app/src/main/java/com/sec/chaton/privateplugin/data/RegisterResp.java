package com.sec.chaton.privateplugin.data;

/* loaded from: classes.dex */
public class RegisterResp {
    private String chatonid;
    private String uid;

    public String getUid() {
        return this.uid;
    }

    public String getChatonid() {
        return this.chatonid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setChatonid(String str) {
        this.chatonid = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RegisterResp [uid=").append(this.uid).append(", chatonid=").append(this.chatonid).append(", getUid()=").append(getUid()).append(", getChatonid()=").append(getChatonid()).append(", getClass()=").append(getClass()).append(", hashCode()=").append(hashCode()).append(", toString()=").append(super.toString()).append("]");
        return sb.toString();
    }
}
