package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class DeviceConfigInfoMeta extends ProtoBufMetaBase {
    public DeviceConfigInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConfigKey", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConfigValue", 2, false, String.class));
    }
}
