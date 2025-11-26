package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class SetFavoriteBuddyRepMeta extends ProtoBufMetaBase {
    public SetFavoriteBuddyRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Favorite", 2, true, String.class));
    }
}
