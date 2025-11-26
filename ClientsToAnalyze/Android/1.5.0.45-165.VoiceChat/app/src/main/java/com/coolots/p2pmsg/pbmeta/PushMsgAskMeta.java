package com.coolots.p2pmsg.pbmeta;

import com.google.protobuf.ByteString;

/* loaded from: classes.dex */
public class PushMsgAskMeta extends ProtoBufMetaBase {
    public PushMsgAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ToID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ToDeviceID", 2, true, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("nestedMsgHeader", 3, true, ByteString.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("nestedMsgBody", 4, true, ByteString.class));
    }
}
