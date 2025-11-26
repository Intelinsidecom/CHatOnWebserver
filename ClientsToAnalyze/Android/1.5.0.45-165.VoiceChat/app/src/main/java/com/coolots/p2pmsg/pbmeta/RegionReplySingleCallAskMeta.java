package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class RegionReplySingleCallAskMeta extends ProtoBufMetaBase {
    public RegionReplySingleCallAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverDeviceID", 3, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderUserNo", 4, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderUserID", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderDeviceID", 6, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderGroupCode", 7, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StartTime", 8, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StatusCode", 9, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallType", 10, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CellularNetwork", 11, false, Short.class));
    }
}
