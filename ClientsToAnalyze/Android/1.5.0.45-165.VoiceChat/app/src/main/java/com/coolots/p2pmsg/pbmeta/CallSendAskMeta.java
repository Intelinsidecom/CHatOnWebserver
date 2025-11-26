package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.P2PUserInfo;
import java.util.Date;

/* loaded from: classes.dex */
public class CallSendAskMeta extends ProtoBufMetaBase {
    public CallSendAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderUserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderUserID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderDeviceID", 3, true, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserID", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushKey", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConnectionType", 7, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SrcUserInfo", 8, true, P2PUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PKey", 9, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrID", 10, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StartDate", 11, true, Date.class));
    }
}
