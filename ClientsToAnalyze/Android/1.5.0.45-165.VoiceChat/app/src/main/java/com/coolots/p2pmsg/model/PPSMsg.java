package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class PPSMsg implements P2PMsgInterface {
    private MsgBody MsgBody;
    private MsgHeader_PPS MsgHeader;

    public PPSMsg() {
    }

    public PPSMsg(MsgHeader_PPS msgHeader, MsgBody msgBody) {
        this.MsgHeader = msgHeader;
        this.MsgBody = msgBody;
    }

    public MsgHeader_PPS getMsgHeader() {
        return this.MsgHeader;
    }

    public void setMsgHeader(MsgHeader_PPS msgHeader) {
        this.MsgHeader = msgHeader;
    }

    @Override // com.coolots.p2pmsg.model.P2PMsgInterface
    public MsgBody getMsgBody() {
        return this.MsgBody;
    }

    public void setMsgBody(MsgBody msgBody) {
        this.MsgBody = msgBody;
    }
}
