package com.coolots.p2pmsg.pbmeta;

import com.sec.spp.push.Config;
import java.util.Date;

/* loaded from: classes.dex */
public class CallSendRepMeta extends ProtoBufMetaBase {
    public CallSendRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("PushKey", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StartDate", 3, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo(Config.EXTRA_ERROR_CODE, 4, true, Integer.TYPE));
    }
}
