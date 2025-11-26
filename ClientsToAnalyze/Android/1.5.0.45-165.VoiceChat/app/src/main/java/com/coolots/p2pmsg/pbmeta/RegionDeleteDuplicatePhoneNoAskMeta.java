package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class RegionDeleteDuplicatePhoneNoAskMeta extends ProtoBufMetaBase {
    public RegionDeleteDuplicatePhoneNoAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 1, true, Long.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneNo", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 3, true, String.class));
    }
}
