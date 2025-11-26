package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class RejectMessageAskMeta extends ProtoBufMetaBase {
    public RejectMessageAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 1, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceID", 2, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RejectMessage", 3, false, String.class));
    }
}
