package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class TTSAsk extends MsgBody {

    /* renamed from: ID */
    private String f22ID;
    private Boolean IsNowPlay;
    private String UserID;

    public String getID() {
        return this.f22ID;
    }

    public void setID(String id) {
        this.f22ID = id;
    }

    public String getUserID() {
        return this.UserID;
    }

    public void setUserID(String userId) {
        this.UserID = userId;
    }

    public Boolean getIsNowPlay() {
        return this.IsNowPlay;
    }

    public void setIsNowPlay(boolean isNowPlay) {
        this.IsNowPlay = Boolean.valueOf(isNowPlay);
    }
}
