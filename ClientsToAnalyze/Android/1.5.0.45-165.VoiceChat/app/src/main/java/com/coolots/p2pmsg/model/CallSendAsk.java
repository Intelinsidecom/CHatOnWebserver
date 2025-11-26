package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import com.coolots.p2pmsg.validator.StringCase;
import java.text.ParseException;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class CallSendAsk extends MsgBody {

    @Size(max = 43, min = 18)
    private String CdrID;

    @StringCase(caseArray = {MakeSingleCallAsk.CALL_TYPE_SINGLE_AUDIO, MakeSingleCallAsk.CALL_TYPE_SINGLE_VIDEO, "MA", "MV"})
    @NotNull
    private String ConnectionType;

    @NotNull
    @Size(max = 8, min = 1)
    private String GroupCode;

    @NotNull
    @Size(max = 100, min = 1)
    private String P2PKey;

    @NotNull
    @Size(max = 100, min = 1)
    private String PushKey;

    @NotNull
    @Size(max = 256, min = 1)
    private String ReceiverUserID;

    @Max(32767)
    @NotNull
    @Min(1)
    private Short SenderDeviceID;

    @NotNull
    @Size(max = 256, min = 1)
    private String SenderUserID;

    @Min(1)
    private long SenderUserNo;

    @NotNull
    private P2PUserInfo SrcUserInfo;
    private Date StartDate;

    public long getSenderUserNo() {
        return this.SenderUserNo;
    }

    public String getSenderUserID() {
        return this.SenderUserID;
    }

    public Short getSenderDeviceID() {
        return this.SenderDeviceID;
    }

    public String getReceiverUserID() {
        return this.ReceiverUserID;
    }

    public String getPushKey() {
        return this.PushKey;
    }

    public String getCdrID() {
        return this.CdrID;
    }

    public String getGroupCode() {
        return this.GroupCode;
    }

    public void setSenderUserNo(long senderUserNo) {
        this.SenderUserNo = senderUserNo;
    }

    public void setSenderUserID(String senderUserID) {
        this.SenderUserID = senderUserID;
    }

    public void setSenderDeviceID(Short senderDeviceID) {
        this.SenderDeviceID = senderDeviceID;
    }

    public void setSenderDeviceID(int senderDeviceID) {
        this.SenderDeviceID = Short.valueOf((short) senderDeviceID);
    }

    public void setReceiverUserID(String receiverUserID) {
        this.ReceiverUserID = receiverUserID;
    }

    public void setPushKey(String pushKey) {
        this.PushKey = pushKey;
    }

    public void setCdrID(String cdrID) {
        this.CdrID = cdrID;
    }

    public void setGroupCode(String groupCode) {
        this.GroupCode = groupCode;
    }

    public Date getStartDate() {
        return this.StartDate;
    }

    public void setStartDate(Date startDate) {
        this.StartDate = startDate;
    }

    public void setStartDate(String startDate) throws ParseException {
        setStartDate(DateTimeUtil.changeFormat(startDate, "yyyy-MM-dd HH:mm:ss"));
    }

    public String getConnectionType() {
        return this.ConnectionType;
    }

    public P2PUserInfo getSrcUserInfo() {
        return this.SrcUserInfo;
    }

    public String getP2PKey() {
        return this.P2PKey;
    }

    public void setConnectionType(String connectionType) {
        this.ConnectionType = connectionType;
    }

    public void setSrcUserInfo(P2PUserInfo srcUserInfo) {
        this.SrcUserInfo = srcUserInfo;
    }

    public void setP2PKey(String p2pKey) {
        this.P2PKey = p2pKey;
    }
}
