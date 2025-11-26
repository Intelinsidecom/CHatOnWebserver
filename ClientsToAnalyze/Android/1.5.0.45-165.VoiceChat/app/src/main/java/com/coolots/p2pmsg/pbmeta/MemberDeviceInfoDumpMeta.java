package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class MemberDeviceInfoDumpMeta extends ProtoBufMetaBase {
    public MemberDeviceInfoDumpMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceId", 2, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceType", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SerialNo", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("LastFailDate", 5, false, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("OsName", 6, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("OsVersion", 7, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceModel", 8, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AppVersion", 9, false, String.class));
    }
}
