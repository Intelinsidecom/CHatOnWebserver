package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class ChatOnJoinRepMeta extends ProtoBufMetaBase {
    public ChatOnJoinRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("Result", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 2, true, Long.class));
    }
}
