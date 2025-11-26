package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class PaidSvcPolicyInfo {
    public static final String SVC_CALL_OUT = "CALL_OUT";
    public static final String SVC_PAID_CONF = "PAID_CONF";
    private boolean Enable;
    private String Service;

    public String getService() {
        return this.Service;
    }

    public void setService(String service) {
        this.Service = service;
    }

    public boolean getEnable() {
        return this.Enable;
    }

    public boolean isEnable() {
        return this.Enable;
    }

    public void setEnable(boolean enable) {
        this.Enable = enable;
    }
}
