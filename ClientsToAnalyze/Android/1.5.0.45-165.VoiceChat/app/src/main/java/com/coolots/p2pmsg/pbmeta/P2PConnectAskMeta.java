package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.P2PUserInfo;

/* loaded from: classes.dex */
public class P2PConnectAskMeta extends ProtoBufMetaBase {
    public P2PConnectAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConnectionType", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SrcUserInfo", 2, true, P2PUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PKey", 3, true, String.class));
    }
}
