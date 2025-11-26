package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class MemberSimpleInfoMeta extends ProtoBufMetaBase {
    public MemberSimpleInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceID", 2, true, Short.class));
    }
}
