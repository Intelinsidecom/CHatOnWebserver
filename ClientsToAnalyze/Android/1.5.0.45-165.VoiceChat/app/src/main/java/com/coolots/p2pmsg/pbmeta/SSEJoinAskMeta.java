package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class SSEJoinAskMeta extends ProtoBufMetaBase {
    public SSEJoinAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SamsungAccountID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserName", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NationalCode", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("BirthDate", 5, false, String.class));
    }
}
