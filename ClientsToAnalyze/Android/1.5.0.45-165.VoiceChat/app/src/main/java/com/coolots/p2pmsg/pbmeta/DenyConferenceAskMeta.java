package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class DenyConferenceAskMeta extends ProtoBufMetaBase {
    public DenyConferenceAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StatusCode", 2, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("RejectedMessage", 3, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CellularNetwork", 4, false, Short.class));
    }
}
