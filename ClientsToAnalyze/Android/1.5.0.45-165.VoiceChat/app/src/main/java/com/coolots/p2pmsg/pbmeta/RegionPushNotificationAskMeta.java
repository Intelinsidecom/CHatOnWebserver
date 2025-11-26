package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.model.PushNotificationAsk;

/* loaded from: classes.dex */
public class RegionPushNotificationAskMeta extends ProtoBufMetaBase {
    public RegionPushNotificationAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("MsgHeader", 1, true, MsgHeader.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushNotificationAsk", 2, true, PushNotificationAsk.class));
    }
}
