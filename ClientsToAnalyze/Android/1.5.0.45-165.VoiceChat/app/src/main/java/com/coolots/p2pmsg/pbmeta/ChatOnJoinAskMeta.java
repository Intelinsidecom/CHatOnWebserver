package com.coolots.p2pmsg.pbmeta;

import com.vlingo.sdk.internal.audio.TTSRequestParams;

/* loaded from: classes.dex */
public class ChatOnJoinAskMeta extends ProtoBufMetaBase {
    public ChatOnJoinAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SamsungAccountID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo(TTSRequestParams.TYPE_EMAIL, 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NationalCode", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("BirthDate", 5, false, String.class));
    }
}
