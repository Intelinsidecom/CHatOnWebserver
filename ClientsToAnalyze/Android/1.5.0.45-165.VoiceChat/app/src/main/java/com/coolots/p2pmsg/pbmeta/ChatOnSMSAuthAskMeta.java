package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class ChatOnSMSAuthAskMeta extends ProtoBufMetaBase {
    public ChatOnSMSAuthAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("GuidSamsungAccount", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DevicePlatform", 2, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CountryCode", 3, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneNo", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceString", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AccessToken", 6, true, String.class));
    }
}
