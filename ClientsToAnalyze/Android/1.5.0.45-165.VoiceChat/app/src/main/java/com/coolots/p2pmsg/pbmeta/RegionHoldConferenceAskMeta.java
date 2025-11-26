package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class RegionHoldConferenceAskMeta extends ProtoBufMetaBase {
    public RegionHoldConferenceAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 3, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("HoldYn", 5, true, String.class));
    }
}
