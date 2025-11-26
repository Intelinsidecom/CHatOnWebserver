package com.coolots.p2pmsg.pbmeta;

import com.vlingo.sdk.internal.audio.TTSRequestParams;

/* loaded from: classes.dex */
public class RegionInfoMeta extends ProtoBufMetaBase {
    public RegionInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SamsungAccountID", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RegionCode", 4, true, Byte.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("ResponseCode", 5, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo(TTSRequestParams.TYPE_EMAIL, 6, true, String.class));
    }
}
