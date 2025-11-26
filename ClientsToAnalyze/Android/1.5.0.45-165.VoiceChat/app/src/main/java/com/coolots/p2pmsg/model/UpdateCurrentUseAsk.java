package com.coolots.p2pmsg.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class UpdateCurrentUseAsk extends MsgBody {

    @Min(0)
    private int CurrentUse;

    @Min(0)
    private int ServerNo;

    @NotNull
    @Size(max = 10)
    private String ServerType;

    public int getCurrentUse() {
        return this.CurrentUse;
    }

    public void setCurrentUse(int currentUse) {
        this.CurrentUse = currentUse;
    }

    public String getServerType() {
        return this.ServerType;
    }

    public void setServerType(String serverType) {
        this.ServerType = serverType;
    }

    public int getServerNo() {
        return this.ServerNo;
    }

    public void setServerNo(int serverNo) {
        this.ServerNo = serverNo;
    }
}
