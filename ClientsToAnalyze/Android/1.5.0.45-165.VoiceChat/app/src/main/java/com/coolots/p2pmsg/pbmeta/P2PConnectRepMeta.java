package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.P2PUserInfo;

/* loaded from: classes.dex */
public class P2PConnectRepMeta extends ProtoBufMetaBase {
    public P2PConnectRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConnectionType", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DstUserInfo", 2, true, P2PUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PKey", 3, true, String.class));
    }
}
