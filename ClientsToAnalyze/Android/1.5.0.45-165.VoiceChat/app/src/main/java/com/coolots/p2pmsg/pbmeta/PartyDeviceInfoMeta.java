package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class PartyDeviceInfoMeta extends ProtoBufMetaBase {
    public PartyDeviceInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceID", 1, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("NetworkType", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PublicIP", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PublicPort", 4, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PrivateIP", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PrivatePort", 6, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RelayType", 7, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RelayServerIP", 8, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RelayServerPort", 9, true, Integer.class));
    }
}
