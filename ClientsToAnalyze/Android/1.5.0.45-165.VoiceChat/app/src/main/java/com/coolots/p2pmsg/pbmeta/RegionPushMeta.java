package com.coolots.p2pmsg.pbmeta;

import com.google.protobuf.ByteString;

/* loaded from: classes.dex */
public class RegionPushMeta extends ProtoBufMetaBase {
    public RegionPushMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceID", 3, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushType", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushMsgHeader", 5, true, ByteString.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushMsgBody", 6, true, ByteString.class));
    }
}
