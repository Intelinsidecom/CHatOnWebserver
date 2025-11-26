package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class CdrReceiveDumpMeta extends ProtoBufMetaBase {
    public CdrReceiveDumpMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrId", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CalleeUserNo", 2, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CalleeUserId", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CalleeDeviceId", 4, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallerUserNo", 5, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallerUserId", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallerDeviceId", 7, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConnectCount", 8, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("StartTime", 9, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AnswerTime", 10, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("EngTime", 11, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Duration", 12, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("RelayYn", 13, false, String.class));
    }
}
