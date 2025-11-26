package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class SetCallForwardingRep extends MsgBody {
    private String ForwardNumber;
    private boolean IsActive;
    private String UserSIPNo;

    public String getUserSIPNo() {
        return this.UserSIPNo;
    }

    public void setUserSIPNo(String userSIPNo) {
        this.UserSIPNo = userSIPNo;
    }

    public boolean isActive() {
        return this.IsActive;
    }

    public boolean getIsActive() {
        return this.IsActive;
    }

    public void setActive(boolean isActive) {
        this.IsActive = isActive;
    }

    public void setIsActive(boolean isActive) {
        this.IsActive = isActive;
    }

    public String getForwardNumber() {
        return this.ForwardNumber;
    }

    public void setForwardNumber(String forwardNumber) {
        this.ForwardNumber = forwardNumber;
    }
}
