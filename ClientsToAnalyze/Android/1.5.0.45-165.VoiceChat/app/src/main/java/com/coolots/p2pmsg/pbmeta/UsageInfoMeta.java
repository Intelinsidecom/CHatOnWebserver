package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class UsageInfoMeta extends ProtoBufMetaBase {
    public UsageInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("TypeCode", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UsageCount", 2, true, Integer.TYPE));
    }
}
