package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class SetCallForwardingAsk extends MsgBody {
    private String ForwardNumber;
    private Boolean IsActive;
    private String UserSIPNo;

    public String getUserSIPNo() {
        return this.UserSIPNo;
    }

    public void setUserSIPNo(String userSIPNo) {
        this.UserSIPNo = userSIPNo;
    }

    public Boolean getIsActive() {
        return this.IsActive;
    }

    public void setIsActive(Boolean isActive) {
        this.IsActive = isActive;
    }

    public String getForwardNumber() {
        return this.ForwardNumber;
    }

    public void setForwardNumber(String forwardNumber) {
        this.ForwardNumber = forwardNumber;
    }
}
