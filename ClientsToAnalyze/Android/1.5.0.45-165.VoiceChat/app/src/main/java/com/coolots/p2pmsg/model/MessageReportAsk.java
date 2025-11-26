package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class MessageReportAsk extends MsgBody {
    private String CdrID;
    private Date ClientCurrentTime;
    private List<Message> MessageList = new ArrayList();
    private String MessageType;

    public String getMessageType() {
        return this.MessageType;
    }

    public void setMessageType(String messageType) {
        this.MessageType = messageType;
    }

    public Date getClientCurrentTime() {
        return this.ClientCurrentTime;
    }

    public void setClientCurrentTime(Date clientCurrentTime) {
        this.ClientCurrentTime = clientCurrentTime;
    }

    public void setClientCurrentTime(String clientCurrentTime) throws ParseException {
        this.ClientCurrentTime = DateTimeUtil.changeFormat(clientCurrentTime, "yyyy-MM-dd HH:mm:ss");
    }

    public String getCdrID() {
        return this.CdrID;
    }

    public void setCdrID(String cdrID) {
        this.CdrID = cdrID;
    }

    public List<Message> getMessageList() {
        return this.MessageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.MessageList = messageList;
    }
}
