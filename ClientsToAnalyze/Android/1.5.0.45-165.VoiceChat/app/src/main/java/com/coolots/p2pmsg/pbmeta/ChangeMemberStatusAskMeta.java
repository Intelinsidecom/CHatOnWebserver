package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class ChangeMemberStatusAskMeta extends ProtoBufMetaBase {
    public ChangeMemberStatusAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReasonCode", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CloseReason", 3, true, String.class));
    }
}
