package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

/* loaded from: classes.dex */
public class UnregisterPhoneNoAsk extends MsgBody {

    @Valid
    private List<PhoneNoInfo> PhoneNoList = new ArrayList();

    public List<PhoneNoInfo> getPhoneNoList() {
        return this.PhoneNoList;
    }

    public void setPhoneNoList(List<PhoneNoInfo> phoneNoList) {
        this.PhoneNoList = phoneNoList;
    }
}
