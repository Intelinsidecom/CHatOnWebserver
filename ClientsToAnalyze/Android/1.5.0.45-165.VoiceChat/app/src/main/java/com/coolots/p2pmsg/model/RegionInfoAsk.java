package com.coolots.p2pmsg.model;

import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class RegionInfoAsk extends MsgBody {

    @Size(max = 2)
    private String Iso2NationCode;

    @Size(max = 10, min = 10)
    private String SamsungAccountID;

    public String getIso2NationCode() {
        return this.Iso2NationCode;
    }

    public void setIso2NationCode(String iso2NationCode) {
        this.Iso2NationCode = iso2NationCode;
    }

    public String getSamsungAccountID() {
        return this.SamsungAccountID;
    }

    public void setSamsungAccountID(String samsungAccountID) {
        this.SamsungAccountID = samsungAccountID;
    }
}
