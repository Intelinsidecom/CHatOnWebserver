package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class TTSAskMeta extends ProtoBufMetaBase {
    public TTSAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ID", 1, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 2, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("IsNowPlay", 3, false, Boolean.class));
    }
}
