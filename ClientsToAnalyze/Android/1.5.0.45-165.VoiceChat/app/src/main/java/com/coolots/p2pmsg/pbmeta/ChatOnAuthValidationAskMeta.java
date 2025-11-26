package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class ChatOnAuthValidationAskMeta extends ProtoBufMetaBase {
    public ChatOnAuthValidationAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("GuidSamsungAccount", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CountryCode", 2, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneNo", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserToken", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AuthNumber", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AccessToken", 6, true, String.class));
    }
}
