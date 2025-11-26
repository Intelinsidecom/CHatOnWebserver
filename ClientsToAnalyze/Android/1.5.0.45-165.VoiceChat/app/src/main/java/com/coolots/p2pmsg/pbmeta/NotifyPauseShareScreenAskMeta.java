package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class NotifyPauseShareScreenAskMeta extends ProtoBufMetaBase {
    public NotifyPauseShareScreenAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallSessionID", 2, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PauseReason", 3, false, Integer.TYPE));
    }
}
