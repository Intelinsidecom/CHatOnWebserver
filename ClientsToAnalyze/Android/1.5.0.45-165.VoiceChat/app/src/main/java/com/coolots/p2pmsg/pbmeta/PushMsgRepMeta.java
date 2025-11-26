package com.coolots.p2pmsg.pbmeta;

import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class PushMsgRepMeta extends ProtoBufMetaBase {
    public PushMsgRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ToID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ToDeviceID", 2, true, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo(Config.EXTRA_ERROR_CODE, 3, true, Integer.TYPE));
    }
}
