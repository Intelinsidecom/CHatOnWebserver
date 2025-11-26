package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class RegionChangeConferenceTypeAskMeta extends ProtoBufMetaBase {
    public RegionChangeConferenceTypeAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceType", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PresenterUserID", 3, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RequestUserNo", 4, false, Long.TYPE));
    }
}
