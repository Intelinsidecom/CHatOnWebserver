package com.coolots.p2pmsg.pbmeta;

import com.vlingo.sdk.internal.audio.TTSRequestParams;

/* loaded from: classes.dex */
public class ChatOnACSAuthAskMeta extends ProtoBufMetaBase {
    public ChatOnACSAuthAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("GuidSamsungAccount", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DevicePlatform", 2, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CountryCode", 3, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneNo", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo(TTSRequestParams.LANG, 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceString", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AccessToken", 7, true, String.class));
    }
}
