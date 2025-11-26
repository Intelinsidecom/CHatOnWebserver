package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class CdrSendCalleeDumpMeta extends ProtoBufMetaBase {
    public CdrSendCalleeDumpMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrId", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CalleeUserNo", 2, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CalleeUserId", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConnectCount", 4, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CalleeDeviceId", 5, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("StatusCode", 6, false, Integer.class));
    }
}
