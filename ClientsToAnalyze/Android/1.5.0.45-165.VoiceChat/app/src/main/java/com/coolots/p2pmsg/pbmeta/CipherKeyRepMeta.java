package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class CipherKeyRepMeta extends ProtoBufMetaBase {
    public CipherKeyRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("CipherKey", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SessionID", 2, true, String.class));
    }
}
