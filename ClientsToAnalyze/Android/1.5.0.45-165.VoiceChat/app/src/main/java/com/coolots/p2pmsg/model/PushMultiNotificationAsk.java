package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.DigitCase;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

/* loaded from: classes.dex */
public class PushMultiNotificationAsk extends MsgBody implements Cloneable {
    private ByteString NestedMsgBody;
    private ByteString NestedMsgHeader;

    @DigitCase(caseArray = {0, 1, 2})
    private int PushGuaranteeType;

    @Size(max = 100, min = 1)
    private String PushKey;

    @NotNull
    @Valid
    @Size(min = 1)
    private List<PushTargetInfo> PushTargetInfoList = new ArrayList();
    private int PushType;

    @NotNull
    @Range(max = 32767, min = 1)
    private Short SenderDeviceID;

    @Min(1)
    private long SenderUserNo;

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

    public List<PushTargetInfo> getPushTargetInfoList() {
        return this.PushTargetInfoList;
    }

    public void setPushTargetInfoList(List<PushTargetInfo> pushTargetInfoList) {
        this.PushTargetInfoList = pushTargetInfoList;
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
        return this.NestedMsgHeader;
    }

    public void setNestedMsgHeader(ByteString nestedMsgHeader) {
        this.NestedMsgHeader = nestedMsgHeader;
    }

    public ByteString getNestedMsgBody() {
        return this.NestedMsgBody;
    }

    public void setNestedMsgBody(ByteString nestedMsgBody) {
        this.NestedMsgBody = nestedMsgBody;
    }

    public int getPushGuaranteeType() {
        return this.PushGuaranteeType;
    }

    public void setPushGuaranteeType(int pushGuaranteeType) {
        this.PushGuaranteeType = pushGuaranteeType;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public PushMultiNotificationAsk m3097clone() throws CloneNotSupportedException {
        return (PushMultiNotificationAsk) super.clone();
    }
}
