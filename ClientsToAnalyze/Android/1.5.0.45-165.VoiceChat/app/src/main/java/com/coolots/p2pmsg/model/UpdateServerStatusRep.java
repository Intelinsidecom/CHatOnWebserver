package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.StringCase;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class UpdateServerStatusRep extends MsgBody {

    @StringCase(caseArray = {"Y", "N"})
    @NotNull
    private String Status;

    public String getStatus() {
        return this.Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }
}
