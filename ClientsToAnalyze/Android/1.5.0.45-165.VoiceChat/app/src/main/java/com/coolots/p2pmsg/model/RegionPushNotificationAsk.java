package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RegionPushNotificationAsk extends MsgBody {
    private MsgHeader MsgHeader;
    private PushNotificationAsk PushNotificationAsk;

    public MsgHeader getMsgHeader() {
        return this.MsgHeader;
    }

    public void setMsgHeader(MsgHeader msgHeader) {
        this.MsgHeader = msgHeader;
    }

    public PushNotificationAsk getPushNotificationAsk() {
        return this.PushNotificationAsk;
    }

    public void setPushNotificationAsk(PushNotificationAsk pushNotificationAsk) {
        this.PushNotificationAsk = pushNotificationAsk;
    }
}
