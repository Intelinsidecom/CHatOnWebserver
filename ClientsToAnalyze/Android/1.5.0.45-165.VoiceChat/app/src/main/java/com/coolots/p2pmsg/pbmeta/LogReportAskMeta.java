package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class LogReportAskMeta extends ProtoBufMetaBase {
    public LogReportAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("AppVersion", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("LogData", 2, true, String.class));
    }
}
