package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class MuteConferenceAskMeta extends ProtoBufMetaBase {
    public MuteConferenceAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MuteVideoYn", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MuteAudioYn", 3, true, String.class));
    }
}
