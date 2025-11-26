package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class EmigrateRepMeta extends ProtoBufMetaBase {
    public EmigrateRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("Region", 1, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Domain", 2, true, String.class));
    }
}
