package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class ConfLimitPolicyInfoMeta extends ProtoBufMetaBase {
    public ConfLimitPolicyInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 1, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PaidType", 2, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConfType", 3, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Limit", 4, false, Short.TYPE));
    }
}
