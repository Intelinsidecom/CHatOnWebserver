package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class BuddySearchAskMeta extends ProtoBufMetaBase {
    public BuddySearchAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SearchType", 1, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CountryCode", 3, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneNo", 4, true, String.class));
    }
}
