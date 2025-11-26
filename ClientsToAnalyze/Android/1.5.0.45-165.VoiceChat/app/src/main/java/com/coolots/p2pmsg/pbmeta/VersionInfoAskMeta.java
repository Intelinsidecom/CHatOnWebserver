package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class VersionInfoAskMeta extends ProtoBufMetaBase {
    public VersionInfoAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("OsName", 1, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("OsVersion", 2, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceModel", 3, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AppVersion", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AppId", 5, false, String.class));
    }
}
