package com.coolots.p2pmsg.pbmeta;

import com.vlingo.sdk.internal.audio.TTSRequestParams;

/* loaded from: classes.dex */
public class NotifyStartShareScreenAskMeta extends ProtoBufMetaBase {
    public NotifyStartShareScreenAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallSessionID", 2, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Width", 3, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Height", 4, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo(TTSRequestParams.VERSION, 5, false, String.class));
    }
}
