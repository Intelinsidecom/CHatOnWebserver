package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.P2PUserInfo;
import com.coolots.p2pmsg.model.Server;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class NotifyMakeSingleCallAskMeta extends ProtoBufMetaBase {
    public NotifyMakeSingleCallAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderUserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderUserID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderDeviceID", 3, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserID", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SrcUserInfo", 5, false, P2PUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PKey", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrID", 7, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StartDate", 8, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Servers", 9, false, List.class, Server.class));
    }
}
