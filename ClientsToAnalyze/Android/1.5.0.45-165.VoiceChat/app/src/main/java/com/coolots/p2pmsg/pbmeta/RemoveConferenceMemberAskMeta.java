package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class RemoveConferenceMemberAskMeta extends ProtoBufMetaBase {
    public RemoveConferenceMemberAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StatusCode", 3, false, Integer.class));
    }
}
