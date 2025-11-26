package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class BuddyStatusInfoMeta extends ProtoBufMetaBase {
    public BuddyStatusInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddyStatus", 2, true, String.class));
    }
}
