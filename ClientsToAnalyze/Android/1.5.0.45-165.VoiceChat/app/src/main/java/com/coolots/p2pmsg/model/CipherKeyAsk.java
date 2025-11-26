package com.coolots.p2pmsg.model;

import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class CipherKeyAsk extends MsgBody {

    @Size(max = 216, min = 216)
    private String PublicKey;
    private Long RequestTime;

    @Size(max = 16, min = 16)
    private String SessionID;

    public String getPublicKey() {
        return this.PublicKey;
    }

    public void setPublicKey(String publicKey) {
        this.PublicKey = publicKey;
    }

    public String getSessionID() {
        return this.SessionID;
    }

    public void setSessionID(String sessionID) {
        this.SessionID = sessionID;
    }

    public Long getRequestTime() {
        return this.RequestTime;
    }

    public void setRequestTime(Long requestTime) {
        this.RequestTime = requestTime;
    }
}
