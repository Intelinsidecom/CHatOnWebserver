package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.P2PUserInfo;

/* loaded from: classes.dex */
public class MakeSingleCallAskMeta extends ProtoBufMetaBase {
    public MakeSingleCallAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConnectionType", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushKey", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PKey", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SrcUserInfo", 5, false, P2PUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CellularNetwork", 6, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AppVersion", 7, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AppId", 8, false, String.class));
    }
}
