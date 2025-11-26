package com.coolots.p2pmsg.pbmeta;

import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class ConnToPushRegisterRepMeta extends ProtoBufMetaBase {
    public ConnToPushRegisterRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo(Config.EXTRA_ERROR_CODE, 1, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushSvrId", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ServerOrder", 3, true, Integer.class));
    }
}
