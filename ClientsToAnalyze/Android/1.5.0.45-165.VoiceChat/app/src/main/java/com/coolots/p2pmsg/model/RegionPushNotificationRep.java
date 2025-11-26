package com.coolots.p2pmsg.model;

import com.google.protobuf.ByteString;

/* loaded from: classes.dex */
public class RegionPushNotificationRep extends MsgBody {
    private MsgHeader MsgHeader;
    private ByteString NestedMsgBody;

    public MsgHeader getMsgHeader() {
        return this.MsgHeader;
    }

    public void setMsgHeader(MsgHeader msgHeader) {
        this.MsgHeader = msgHeader;
    }

    public ByteString getNestedMsgBody() {
        return this.NestedMsgBody;
    }

    public void setNestedMsgBody(ByteString nestedMsgBody) {
        this.NestedMsgBody = nestedMsgBody;
    }
}
