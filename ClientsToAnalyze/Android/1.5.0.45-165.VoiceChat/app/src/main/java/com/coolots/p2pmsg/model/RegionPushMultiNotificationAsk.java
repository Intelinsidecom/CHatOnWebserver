package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RegionPushMultiNotificationAsk extends MsgBody {
    private MsgHeader MsgHeader;
    private PushMultiNotificationAsk PushMultiNotificationAsk;

    public MsgHeader getMsgHeader() {
        return this.MsgHeader;
    }

    public void setMsgHeader(MsgHeader msgHeader) {
        this.MsgHeader = msgHeader;
    }

    public PushMultiNotificationAsk getPushMultiNotificationAsk() {
        return this.PushMultiNotificationAsk;
    }

    public void setPushMultiNotificationAsk(PushMultiNotificationAsk pushMultiNotificationAsk) {
        this.PushMultiNotificationAsk = pushMultiNotificationAsk;
    }
}
