package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.P2PUserInfo;

/* loaded from: classes.dex */
public class RegionEnterSingleCallAskMeta extends ProtoBufMetaBase {
    public RegionEnterSingleCallAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderUserID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderUserNo", 2, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderDeviceID", 3, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConnectCount", 4, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderGroupCode", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserID", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserNo", 7, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverDeviceID", 8, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushKey", 9, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PKey", 10, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DstUserInfo", 11, true, P2PUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrID", 12, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CellularNetwork", 13, false, Short.class));
    }
}
