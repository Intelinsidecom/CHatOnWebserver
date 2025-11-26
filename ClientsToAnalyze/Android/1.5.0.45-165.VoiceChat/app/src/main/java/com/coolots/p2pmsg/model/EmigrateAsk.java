package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class EmigrateAsk extends MsgBody {
    private short ToRegion;

    public short getToRegion() {
        return this.ToRegion;
    }

    public void setToRegion(short toRegion) {
        this.ToRegion = toRegion;
    }

    public void setToRegion(int toRegion) {
        this.ToRegion = (short) toRegion;
    }
}
