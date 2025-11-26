package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class DeleteImageAskMeta extends ProtoBufMetaBase {
    public DeleteImageAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ImageType", 1, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddyGroupCode", 2, true, Long.TYPE));
    }
}
