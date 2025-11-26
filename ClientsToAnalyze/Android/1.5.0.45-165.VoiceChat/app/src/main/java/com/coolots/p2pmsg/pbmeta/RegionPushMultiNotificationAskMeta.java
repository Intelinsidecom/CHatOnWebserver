package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.model.PushMultiNotificationAsk;

/* loaded from: classes.dex */
public class RegionPushMultiNotificationAskMeta extends ProtoBufMetaBase {
    public RegionPushMultiNotificationAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("MsgHeader", 1, true, MsgHeader.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushMultiNotificationAsk", 2, true, PushMultiNotificationAsk.class));
    }
}
