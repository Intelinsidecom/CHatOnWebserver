package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class PhoneNoInfoMeta extends ProtoBufMetaBase {
    public PhoneNoInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Privacy", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceID", 3, true, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Status", 4, true, String.class));
    }
}
