package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/* loaded from: classes.dex */
public class WithdrawMemberRep extends MsgBody {

    @NotNull
    @Pattern(regexp = "[11]{1}")
    private String Result;

    public String getResult() {
        return this.Result;
    }

    public void setResult(String result) {
        this.Result = result;
    }
}
