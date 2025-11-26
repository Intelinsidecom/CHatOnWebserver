package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.StringCase;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class UpdateServerStatusAsk extends MsgBody {

    @Min(0)
    private int ServerNo;

    @NotNull
    @Size(max = 10)
    private String ServerType;

    @StringCase(caseArray = {"Y", "N"})
    @NotNull
    private String Status;

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

    public String getStatus() {
        return this.Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }
}
