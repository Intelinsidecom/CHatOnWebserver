package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class GetCallPresenceRepMeta extends ProtoBufMetaBase {
    public GetCallPresenceRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceID", 2, true, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Presence", 3, true, String.class));
    }
}
