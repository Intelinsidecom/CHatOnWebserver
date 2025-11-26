package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class NotifyCallTypeChangeAskMeta extends ProtoBufMetaBase {
    public NotifyCallTypeChangeAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MediaType", 2, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("RequestKey", 3, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Result", 4, true, Boolean.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallSessionID", 5, false, Integer.TYPE));
    }
}
