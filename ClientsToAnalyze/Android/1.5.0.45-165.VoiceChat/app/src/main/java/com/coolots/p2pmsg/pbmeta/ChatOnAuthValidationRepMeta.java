package com.coolots.p2pmsg.pbmeta;

import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class ChatOnAuthValidationRepMeta extends ProtoBufMetaBase {
    public ChatOnAuthValidationRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ValidationTime", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("JoinStatus", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo(Config.EXTRA_ERROR_CODE, 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ErrorMsg", 4, true, String.class));
    }
}
