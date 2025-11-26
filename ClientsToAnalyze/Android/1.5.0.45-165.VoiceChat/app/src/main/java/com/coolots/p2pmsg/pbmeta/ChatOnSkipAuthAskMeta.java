package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class ChatOnSkipAuthAskMeta extends ProtoBufMetaBase {
    public ChatOnSkipAuthAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SamsungAccountID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AccessToken", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CountryCode", 3, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneNo", 4, true, String.class));
    }
}
