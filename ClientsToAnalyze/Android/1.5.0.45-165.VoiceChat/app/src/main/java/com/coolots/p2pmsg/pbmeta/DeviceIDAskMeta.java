package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class DeviceIDAskMeta extends ProtoBufMetaBase {
    public DeviceIDAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceType", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SerialNo", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("OsName", 3, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("OsVersion", 4, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceModel", 5, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AppVersion", 6, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ApplicationID", 7, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MCC", 8, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MNC", 9, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PassWord", 10, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AuthID", 11, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ChatOnUID", 12, false, String.class));
    }
}
