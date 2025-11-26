package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.SIPNo;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class ReturnPhoneNoAsk extends MsgBody {

    @SIPNo
    @NotNull
    private String PhoneNo = null;

    public String getPhoneNo() {
        return this.PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.PhoneNo = phoneNo;
    }
}
