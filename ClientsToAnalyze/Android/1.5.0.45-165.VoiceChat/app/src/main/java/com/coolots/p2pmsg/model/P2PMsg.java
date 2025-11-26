package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class P2PMsg {
    private MsgBody MsgBody;
    private MsgHeader MsgHeader;

    public P2PMsg() {
    }

    public P2PMsg(MsgHeader msgHeader, MsgBody msgBody) {
        this.MsgHeader = msgHeader;
        this.MsgBody = msgBody;
    }

    public MsgHeader getMsgHeader() {
        return this.MsgHeader;
    }

    public void setMsgHeader(MsgHeader msgHeader) {
        this.MsgHeader = msgHeader;
    }

    public MsgBody getMsgBody() {
        return this.MsgBody;
    }

    public void setMsgBody(MsgBody msgBody) {
        this.MsgBody = msgBody;
    }
}
