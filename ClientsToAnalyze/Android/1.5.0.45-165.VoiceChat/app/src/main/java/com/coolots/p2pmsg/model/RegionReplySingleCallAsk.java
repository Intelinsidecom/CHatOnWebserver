package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes.dex */
public class RegionReplySingleCallAsk extends MsgBody {
    private String CallType;
    private String CdrID;
    private Short CellularNetwork;
    private short ReceiverDeviceID;
    private String ReceiverUserID;
    private short SenderDeviceID;
    private String SenderGroupCode;
    private String SenderUserID;
    private long SenderUserNo;
    private Date StartTime;
    private int StatusCode;

    public String getCdrID() {
        return this.CdrID;
    }

    public void setCdrID(String cdrID) {
        this.CdrID = cdrID;
    }

    public String getReceiverUserID() {
        return this.ReceiverUserID;
    }

    public void setReceiverUserID(String receiverUserID) {
        this.ReceiverUserID = receiverUserID;
    }

    public short getReceiverDeviceID() {
        return this.ReceiverDeviceID;
    }

    public void setReceiverDeviceID(short receiverDeviceID) {
        this.ReceiverDeviceID = receiverDeviceID;
    }

    public void setReceiverDeviceID(int receiverDeviceID) {
        this.ReceiverDeviceID = (short) receiverDeviceID;
    }

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

    public Date getStartTime() {
        return this.StartTime;
    }

    public void setStartTime(Date startTime) {
        if (startTime instanceof Timestamp) {
            this.StartTime = new Date(startTime.getTime());
        } else {
            this.StartTime = startTime;
        }
    }

    public void setStartTime(String startDate) throws ParseException {
        setStartTime(DateTimeUtil.changeFormat(startDate, "yyyy-MM-dd HH:mm:ss"));
    }

    public int getStatusCode() {
        return this.StatusCode;
    }

    public void setStatusCode(int statusCode) {
        this.StatusCode = statusCode;
    }

    public String getCallType() {
        return this.CallType;
    }

    public void setCallType(String callType) {
        this.CallType = callType;
    }

    public Short getCellularNetwork() {
        return this.CellularNetwork;
    }

    public void setCellularNetwork(Short cellularNetwork) {
        this.CellularNetwork = cellularNetwork;
    }

    public void setCellularNetwork(int cellularNetwork) {
        this.CellularNetwork = Short.valueOf((short) cellularNetwork);
    }
}
