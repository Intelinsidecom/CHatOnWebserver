package com.coolots.p2pmsg.pbmeta;

import com.vlingo.sdk.internal.audio.TTSRequestParams;

/* loaded from: classes.dex */
public class MsgHeaderMeta extends ProtoBufMetaBase {
    public MsgHeaderMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo(TTSRequestParams.VERSION, 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo(TTSRequestParams.FROM, 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SvcCode", 3, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("MsgCode", 4, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("MsgKey", 5, false, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("FromID", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ToID", 7, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("FromDeviceID", 8, true, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Passwd", 9, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SSID", 10, false, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SCID", 11, false, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RSID", 12, false, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RCID", 13, false, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SLC", 14, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 15, true, Long.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DUKey", 16, false, String.class));
    }
}
