package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class RegionMuteConferenceAskMeta extends ProtoBufMetaBase {
    public RegionMuteConferenceAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RequestUserID", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RequestUserNo", 4, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("MuteVideoYn", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MuteAudioYn", 6, true, String.class));
    }
}
