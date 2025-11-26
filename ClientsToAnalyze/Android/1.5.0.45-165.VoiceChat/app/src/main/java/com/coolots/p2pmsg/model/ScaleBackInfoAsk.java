package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class ScaleBackInfoAsk extends MsgBody {
    private String serverType;
    private String service;

    public String getServerType() {
        return this.serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public String getService() {
        return this.service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
