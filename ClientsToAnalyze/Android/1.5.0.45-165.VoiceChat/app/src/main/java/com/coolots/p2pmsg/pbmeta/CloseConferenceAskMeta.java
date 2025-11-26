package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class CloseConferenceAskMeta extends ProtoBufMetaBase {
    public CloseConferenceAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StatusCode", 2, false, Integer.class));
    }
}
