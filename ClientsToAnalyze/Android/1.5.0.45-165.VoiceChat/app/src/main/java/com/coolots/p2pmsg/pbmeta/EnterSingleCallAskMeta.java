package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.P2PUserInfo;

/* loaded from: classes.dex */
public class EnterSingleCallAskMeta extends ProtoBufMetaBase {
    public EnterSingleCallAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverDeviceID", 2, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushKey", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PKey", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DstUserInfo", 5, true, P2PUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrID", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserNo", 7, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CellularNetwork", 8, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AppVersion", 9, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AppId", 10, false, String.class));
    }
}
