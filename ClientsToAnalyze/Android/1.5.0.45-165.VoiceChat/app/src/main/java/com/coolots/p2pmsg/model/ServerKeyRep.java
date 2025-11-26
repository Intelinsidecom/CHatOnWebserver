package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class ServerKeyRep extends MsgBody {

    @NotNull
    @Size(max = 24, min = 24)
    private String CipherKey;

    public String getCipherKey() {
        return this.CipherKey;
    }

    public void setCipherKey(String cipherKey) {
        this.CipherKey = cipherKey;
    }
}
