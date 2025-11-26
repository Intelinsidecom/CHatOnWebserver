package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class CipherKeyAskMeta extends ProtoBufMetaBase {
    public CipherKeyAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("PublicKey", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SessionID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RequestTime", 3, false, Long.class));
    }
}
