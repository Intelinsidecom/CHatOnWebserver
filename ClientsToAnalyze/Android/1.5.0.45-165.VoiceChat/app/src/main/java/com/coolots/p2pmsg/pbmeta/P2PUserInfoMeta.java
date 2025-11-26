package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class P2PUserInfoMeta extends ProtoBufMetaBase {
    public P2PUserInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 2, true, Long.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceID", 3, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NetworkType", 4, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PublicIP", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PublicPort", 6, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PrivateIP", 7, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PrivatePort", 8, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RelayServerIP", 9, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RelayServerPort", 10, true, Integer.class));
    }
}
