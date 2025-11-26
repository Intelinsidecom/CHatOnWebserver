package com.coolots.p2pmsg.pbmeta;

import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class ClientToConnUnregisterRepMeta extends ProtoBufMetaBase {
    public ClientToConnUnregisterRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo(Config.EXTRA_ERROR_CODE, 2, true, Integer.TYPE));
    }
}
