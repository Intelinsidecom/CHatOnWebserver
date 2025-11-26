package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class CallTypeChangeRepMeta extends ProtoBufMetaBase {
    public CallTypeChangeRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MediaType", 2, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("RequestKey", 3, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Response", 4, true, Boolean.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallSessionID", 6, false, Integer.TYPE));
    }
}
