package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.P2PUserInfo;

/* loaded from: classes.dex */
public class CallRecvAskMeta extends ProtoBufMetaBase {
    public CallRecvAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderUserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderUserID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderDeviceID", 3, true, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserID", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverDeviceID", 5, true, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushKey", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrID", 7, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 8, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConnectionType", 9, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DstUserInfo", 10, true, P2PUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PKey", 11, true, String.class));
    }
}
