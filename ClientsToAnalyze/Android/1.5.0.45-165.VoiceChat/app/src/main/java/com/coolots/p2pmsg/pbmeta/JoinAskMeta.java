package com.coolots.p2pmsg.pbmeta;

import com.vlingo.sdk.internal.audio.TTSRequestParams;

/* loaded from: classes.dex */
public class JoinAskMeta extends ProtoBufMetaBase {
    public JoinAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Passwd", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserName", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NationalCode", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("USimPhoneNo", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AuthID", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CountryCode", 7, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneNo", 8, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo(TTSRequestParams.TYPE_EMAIL, 9, true, String.class));
    }
}
