package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class CallTypeChangeAskMeta extends ProtoBufMetaBase {
    public CallTypeChangeAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MediaType", 2, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("RequestKey", 3, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("RequesterID", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallSessionID", 5, false, Integer.TYPE));
    }
}
