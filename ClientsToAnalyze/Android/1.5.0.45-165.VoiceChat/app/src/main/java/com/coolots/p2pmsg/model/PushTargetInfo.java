package com.coolots.p2pmsg.model;

import com.coolots.common.util.StringUtil;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

/* loaded from: classes.dex */
public class PushTargetInfo {
    private String PushGuaranteeKey;

    @NotNull
    @Range(max = 32767, min = 1)
    private Short ReceiverDeviceID;

    @Size(max = 128, min = 1)
    private String ReceiverUserID;

    @Min(1)
    private Long ReceiverUserNo;

    public Long getReceiverUserNo() {
        return this.ReceiverUserNo;
    }

    public void setReceiverUserNo(Long receiverUserNo) {
        this.ReceiverUserNo = receiverUserNo;
    }

    public String getReceiverUserID() {
        return this.ReceiverUserID;
    }

    public void setReceiverUserID(String receiverUserID) {
        this.ReceiverUserID = receiverUserID;
    }

    public Short getReceiverDeviceID() {
        return this.ReceiverDeviceID;
    }

    public void setReceiverDeviceID(Short receiverDeviceID) {
        this.ReceiverDeviceID = receiverDeviceID;
    }

    public void setReceiverDeviceID(int receiverDeviceID) {
        this.ReceiverDeviceID = Short.valueOf((short) receiverDeviceID);
    }

    public void setPushGuaranteeKey(String pushGuaranteeKey) {
        this.PushGuaranteeKey = pushGuaranteeKey;
    }

    public String getPushGuaranteeKey() {
        return this.PushGuaranteeKey;
    }

    public String toString() {
        return StringUtil.classToString(this);
    }
}
