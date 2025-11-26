package com.coolots.p2pmsg.pbmeta;

import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class ChatOnACSAuthRepMeta extends ProtoBufMetaBase {
    public ChatOnACSAuthRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserToken", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo(Config.EXTRA_ERROR_CODE, 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ErrorMsg", 3, true, String.class));
    }
}
