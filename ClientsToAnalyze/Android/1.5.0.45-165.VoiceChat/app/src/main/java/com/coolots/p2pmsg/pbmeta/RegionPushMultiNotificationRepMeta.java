package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.MsgHeader;
import com.google.protobuf.ByteString;

/* loaded from: classes.dex */
public class RegionPushMultiNotificationRepMeta extends ProtoBufMetaBase {
    public RegionPushMultiNotificationRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("MsgHeader", 1, true, MsgHeader.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NestedMsgBody", 2, true, ByteString.class));
    }
}
