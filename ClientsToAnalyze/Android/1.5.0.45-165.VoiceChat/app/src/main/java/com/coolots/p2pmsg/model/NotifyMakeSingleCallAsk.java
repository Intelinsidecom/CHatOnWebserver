package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class NotifyMakeSingleCallAsk extends MsgBody {

    @NotNull
    @Size(max = 43, min = 18)
    private String CdrID;

    @NotNull
    @Size(max = 100, min = 1)
    private String P2PKey;

    @NotNull
    @Size(max = 256, min = 1)
    private String ReceiverUserID;

    @Max(32767)
    @Min(1)
    private short SenderDeviceID;

    @NotNull
    @Size(max = 256, min = 1)
    private String SenderUserID;

    @Min(1)
    private long SenderUserNo;

    @Valid
    @Size(min = 1)
    private List<Server> Servers = new ArrayList();
    private P2PUserInfo SrcUserInfo;

    @NotNull
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

    public List<Server> getServers() {
        return this.Servers;
    }

    public void setServers(List<Server> servers) {
        this.Servers = servers;
    }
}
