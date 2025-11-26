package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RegionInfoIPRep extends MsgBody {
    private String Domain;

    /* renamed from: IP */
    private String f18IP;
    private short Region;

    public short getRegion() {
        return this.Region;
    }

    public void setRegion(short region) {
        this.Region = region;
    }

    public void setRegion(int region) {
        this.Region = (short) region;
    }

    public String getDomain() {
        return this.Domain;
    }

    public void setDomain(String domain) {
        this.Domain = domain;
    }

    public String getIP() {
        return this.f18IP;
    }

    public void setIP(String iP) {
        this.f18IP = iP;
    }
}
