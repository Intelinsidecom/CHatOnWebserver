package com.coolots.p2pmsg.pbmeta;

import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class RelayUnregisterRepMeta extends ProtoBufMetaBase {
    public RelayUnregisterRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo(Config.EXTRA_ERROR_CODE, 2, true, Integer.TYPE));
    }
}
