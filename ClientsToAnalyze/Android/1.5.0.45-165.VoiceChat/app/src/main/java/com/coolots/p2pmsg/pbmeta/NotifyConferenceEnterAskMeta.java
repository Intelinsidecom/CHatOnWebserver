package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class NotifyConferenceEnterAskMeta extends ProtoBufMetaBase {
    public NotifyConferenceEnterAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PKey", 2, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("EventID", 3, false, String.class));
    }
}
