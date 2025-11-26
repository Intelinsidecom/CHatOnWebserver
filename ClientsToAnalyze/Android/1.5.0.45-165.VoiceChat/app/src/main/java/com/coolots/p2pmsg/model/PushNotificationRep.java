package com.coolots.p2pmsg.model;

import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class PushNotificationRep extends MsgBody {
    private int ErrorCode;
    private String PushGuaranteeKey;

    @Size(max = 100, min = 1)
    private String PushKey;

    public int getErrorCode() {
        return this.ErrorCode;
    }

    public void setErrorCode(int errorCode) {
        this.ErrorCode = errorCode;
    }

    public String getPushKey() {
        return this.PushKey;
    }

    public void setPushKey(String pushKey) {
        this.PushKey = pushKey;
    }

    public String getPushGuaranteeKey() {
        return this.PushGuaranteeKey;
    }

    public void setPushGuaranteeKey(String pushGuaranteeKey) {
        this.PushGuaranteeKey = pushGuaranteeKey;
    }
}
