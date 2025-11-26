package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.DigitCase;
import com.google.protobuf.ByteString;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class PushNotificationAsk extends MsgBody {
    private String PushGuaranteeKey;

    @DigitCase(caseArray = {0, 1, 2})
    private int PushGuaranteeType;

    @Size(max = 100, min = 1)
    private String PushKey;
    private int PushType;

    @Max(32767)
    @Min(1)
    private Short ReceiverDeviceID;

    @Size(max = 128, min = 1)
    private String ReceiverUserID;

    @Min(1)
    private Long ReceiverUserNo;
    private Short SenderDeviceID;
    private long SenderUserNo;
    private ByteString nestedMsgBody;
    private ByteString nestedMsgHeader;

    public long getSenderUserNo() {
        return this.SenderUserNo;
    }

    public void setSenderUserNo(long senderUserNo) {
        this.SenderUserNo = senderUserNo;
    }

    public Short getSenderDeviceID() {
        return this.SenderDeviceID;
    }

    public void setSenderDeviceID(int senderDeviceID) {
        this.SenderDeviceID = Short.valueOf((short) senderDeviceID);
    }

    public void setSenderDeviceID(Short senderDeviceID) {
        this.SenderDeviceID = senderDeviceID;
    }

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

    public String getPushKey() {
        return this.PushKey;
    }

    public void setPushKey(String pushKey) {
        this.PushKey = pushKey;
    }

    public int getPushType() {
        return this.PushType;
    }

    public void setPushType(int pushType) {
        this.PushType = pushType;
    }

    public ByteString getNestedMsgHeader() {
        return this.nestedMsgHeader;
    }

    public void setNestedMsgHeader(ByteString nestedMsgHeader) {
        this.nestedMsgHeader = nestedMsgHeader;
    }

    public ByteString getNestedMsgBody() {
        return this.nestedMsgBody;
    }

    public void setNestedMsgBody(ByteString nestedMsgBody) {
        this.nestedMsgBody = nestedMsgBody;
    }

    public int getPushGuaranteeType() {
        return this.PushGuaranteeType;
    }

    public void setPushGuaranteeType(int pushGuaranteeType) {
        this.PushGuaranteeType = pushGuaranteeType;
    }

    public String getPushGuaranteeKey() {
        return this.PushGuaranteeKey;
    }

    public void setPushGuaranteeKey(String pushGuaranteeKey) {
        this.PushGuaranteeKey = pushGuaranteeKey;
    }
}
