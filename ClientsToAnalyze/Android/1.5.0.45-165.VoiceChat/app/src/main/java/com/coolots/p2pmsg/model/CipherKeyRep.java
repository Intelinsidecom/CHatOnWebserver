package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class CipherKeyRep extends MsgBody {

    @NotNull
    @Size(max = 24, min = 24)
    private String CipherKey;

    @NotNull
    @Size(max = 16, min = 16)
    private String SessionID;

    public String getCipherKey() {
        return this.CipherKey;
    }

    public void setCipherKey(String cipherKey) {
        this.CipherKey = cipherKey;
    }

    public String getSessionID() {
        return this.SessionID;
    }

    public void setSessionID(String sessionID) {
        this.SessionID = sessionID;
    }
}
