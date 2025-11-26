package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class ConfigInfoMeta extends ProtoBufMetaBase {
    public ConfigInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("key", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("value", 2, true, String.class));
    }
}
