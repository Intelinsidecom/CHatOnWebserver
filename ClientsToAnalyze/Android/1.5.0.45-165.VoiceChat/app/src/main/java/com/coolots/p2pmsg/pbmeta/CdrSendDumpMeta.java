package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class CdrSendDumpMeta extends ProtoBufMetaBase {
    public CdrSendDumpMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrId", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallerUserNo", 2, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallerUserId", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallerDeviceId", 4, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("StartTime", 5, false, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AnswerTime", 6, false, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("EndTime", 7, false, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Pdd", 8, false, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Duration", 9, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallType", 10, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 11, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RelayYn", 12, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StatusCode", 13, false, Integer.class));
    }
}
