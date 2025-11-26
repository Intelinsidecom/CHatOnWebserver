package com.coolots.p2pmsg.pbmeta;

import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class PushNotificationRepMeta extends ProtoBufMetaBase {
    public PushNotificationRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("PushKey", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo(Config.EXTRA_ERROR_CODE, 2, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushGuaranteeKey", 3, true, String.class));
    }
}
