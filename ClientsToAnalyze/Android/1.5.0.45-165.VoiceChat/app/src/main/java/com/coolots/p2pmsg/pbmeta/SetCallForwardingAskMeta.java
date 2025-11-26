package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class SetCallForwardingAskMeta extends ProtoBufMetaBase {
    public SetCallForwardingAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserSIPNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("IsActive", 2, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ForwardNumber", 3, true, String.class));
    }
}
