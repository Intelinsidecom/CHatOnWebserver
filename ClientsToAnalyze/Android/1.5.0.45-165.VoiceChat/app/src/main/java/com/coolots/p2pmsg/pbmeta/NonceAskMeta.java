package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class NonceAskMeta extends ProtoBufMetaBase {
    public NonceAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("AppVersion", 1, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ApplicationID", 2, false, String.class));
    }
}
