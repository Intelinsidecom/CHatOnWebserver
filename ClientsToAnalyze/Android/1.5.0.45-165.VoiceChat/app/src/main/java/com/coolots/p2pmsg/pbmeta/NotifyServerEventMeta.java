package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class NotifyServerEventMeta extends ProtoBufMetaBase {
    public NotifyServerEventMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ServerType", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ServerNo", 2, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("EventType", 3, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("EventDesc", 4, true, String.class));
    }
}
