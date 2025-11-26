package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class NationalPhoneCodeRep extends MsgBody {
    private List<NationalPhoneCode> NationalPhoneCodeSet = new ArrayList();
    private String Version;

    public String getVersion() {
        return this.Version;
    }

    public void setVersion(String version) {
        this.Version = version;
    }

    public List<NationalPhoneCode> getNationalPhoneCodeSet() {
        return this.NationalPhoneCodeSet;
    }

    public void setNationalPhoneCodeSet(List<NationalPhoneCode> nationalPhoneCodeSet) {
        this.NationalPhoneCodeSet = nationalPhoneCodeSet;
    }
}
