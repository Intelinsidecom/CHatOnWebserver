package com.coolots.p2pmsg.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class UpdateServerKeyAsk extends MsgBody {

    @NotNull
    @Size(max = 24, min = 24)
    private String CipherKey;

    @Min(0)
    private int ServerNo;

    @NotNull
    @Size(max = 10)
    private String ServerType;

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

    public String getCipherKey() {
        return this.CipherKey;
    }

    public void setCipherKey(String cipherKey) {
        this.CipherKey = cipherKey;
    }
}
