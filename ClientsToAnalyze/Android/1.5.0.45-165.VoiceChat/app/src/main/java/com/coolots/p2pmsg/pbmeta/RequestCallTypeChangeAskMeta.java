package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class RequestCallTypeChangeAskMeta extends ProtoBufMetaBase {
    public RequestCallTypeChangeAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MediaType", 2, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallSessionID", 4, false, Integer.TYPE));
    }
}
