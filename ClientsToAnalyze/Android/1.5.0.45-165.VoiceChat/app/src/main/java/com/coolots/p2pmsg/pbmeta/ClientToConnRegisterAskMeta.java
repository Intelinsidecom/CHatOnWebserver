package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class ClientToConnRegisterAskMeta extends ProtoBufMetaBase {
    public ClientToConnRegisterAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 2, true, String.class));
    }
}
