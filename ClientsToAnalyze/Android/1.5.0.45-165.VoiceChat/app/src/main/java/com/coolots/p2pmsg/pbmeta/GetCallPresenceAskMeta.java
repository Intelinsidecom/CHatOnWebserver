package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class GetCallPresenceAskMeta extends ProtoBufMetaBase {
    public GetCallPresenceAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceID", 2, true, Short.class));
    }
}
