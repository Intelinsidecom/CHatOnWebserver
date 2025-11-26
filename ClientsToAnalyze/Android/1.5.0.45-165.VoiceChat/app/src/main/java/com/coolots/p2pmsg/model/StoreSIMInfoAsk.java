package com.coolots.p2pmsg.model;

import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class StoreSIMInfoAsk extends MsgBody {

    @Size(max = 3, min = 3)
    private String MCC;

    @Size(max = 3, min = 0)
    private String MNC;

    public String getMCC() {
        return this.MCC;
    }

    public void setMCC(String mCC) {
        this.MCC = mCC;
    }

    public String getMNC() {
        return this.MNC;
    }

    public void setMNC(String mNC) {
        this.MNC = mNC;
    }
}
