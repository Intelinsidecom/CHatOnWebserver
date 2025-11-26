package com.sec.chaton.privateplugin.data;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class SetSpamReq {
    private String imei;
    private String imsi;
    private String msisdn;
    private ArrayList<Spam> spam = new ArrayList<>();

    public SetSpamReq setMsisdn(String str) {
        this.msisdn = str;
        return this;
    }

    public SetSpamReq setImei(String str) {
        this.imei = str;
        return this;
    }

    public SetSpamReq setImsi(String str) {
        this.imsi = str;
        return this;
    }

    public SetSpamReq setSpam(Spam spam) {
        this.spam.add(spam);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SetSpamReq [msisdn=").append(this.msisdn).append(", imei=").append(this.imei).append(", imsi=").append(this.imsi).append(", spam=").append(this.spam).append("]");
        return sb.toString();
    }
}
