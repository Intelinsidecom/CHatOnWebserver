package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes.dex */
public class RegionMakeSingleCallAsk extends MsgBody {
    private String CdrID;
    private String P2PKey;
    private String ReceiverUserID;
    private short SenderDeviceID;
    private String SenderEmail;
    private String SenderGroupCode;
    private String SenderUserID;
    private long SenderUserNo;
    private P2PUserInfo SrcUserInfo;
    private Date StartDate;

    public long getSenderUserNo() {
        return this.SenderUserNo;
    }

    public void setSenderUserNo(long senderUserNo) {
        this.SenderUserNo = senderUserNo;
    }

    public String getSenderUserID() {
        return this.SenderUserID;
    }

    public void setSenderUserID(String senderUserID) {
        this.SenderUserID = senderUserID;
    }

    public short getSenderDeviceID() {
        return this.SenderDeviceID;
    }

    public void setSenderDeviceID(short senderDeviceID) {
        this.SenderDeviceID = senderDeviceID;
    }

    public void setSenderDeviceID(int senderDeviceID) {
        this.SenderDeviceID = (short) senderDeviceID;
    }

    public String getSenderGroupCode() {
        return this.SenderGroupCode;
    }

    public void setSenderGroupCode(String senderGroupCode) {
        this.SenderGroupCode = senderGroupCode;
    }

    public String getReceiverUserID() {
        return this.ReceiverUserID;
    }

    public void setReceiverUserID(String receiverUserID) {
        this.ReceiverUserID = receiverUserID;
    }

    public P2PUserInfo getSrcUserInfo() {
        return this.SrcUserInfo;
    }

    public void setSrcUserInfo(P2PUserInfo srcUserInfo) {
        this.SrcUserInfo = srcUserInfo;
    }

    public String getP2PKey() {
        return this.P2PKey;
    }

    public void setP2PKey(String p2pKey) {
        this.P2PKey = p2pKey;
    }

    public String getCdrID() {
        return this.CdrID;
    }

    public void setCdrID(String cdrID) {
        this.CdrID = cdrID;
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

    public String getSenderEmail() {
        return this.SenderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.SenderEmail = senderEmail;
    }
}
