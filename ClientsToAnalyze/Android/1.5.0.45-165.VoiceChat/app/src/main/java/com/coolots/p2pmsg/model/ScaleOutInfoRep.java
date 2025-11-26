package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class ScaleOutInfoRep extends MsgBody {
    private String returnValue;
    private int serverNo;
    private String serverType;

    public String getServerType() {
        return this.serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public int getServerNo() {
        return this.serverNo;
    }

    public void setServerNo(int serverNo) {
        this.serverNo = serverNo;
    }

    public String getReturnValue() {
        return this.returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }
}
