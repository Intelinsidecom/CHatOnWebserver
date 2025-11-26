package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.P2PUserInfo;

/* loaded from: classes.dex */
public class NotifyEnterSingleCallAskMeta extends ProtoBufMetaBase {
    public NotifyEnterSingleCallAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderUserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderUserID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderDeviceID", 3, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserID", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverDeviceID", 5, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("DstUserInfo", 6, true, P2PUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PKey", 7, true, String.class));
    }
}
