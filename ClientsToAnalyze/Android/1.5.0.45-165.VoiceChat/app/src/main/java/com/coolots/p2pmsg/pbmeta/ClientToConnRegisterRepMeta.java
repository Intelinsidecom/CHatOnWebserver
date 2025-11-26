package com.coolots.p2pmsg.pbmeta;

import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class ClientToConnRegisterRepMeta extends ProtoBufMetaBase {
    public ClientToConnRegisterRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PublicIP", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PublicPort", 3, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo(Config.EXTRA_ERROR_CODE, 4, true, Integer.TYPE));
    }
}
