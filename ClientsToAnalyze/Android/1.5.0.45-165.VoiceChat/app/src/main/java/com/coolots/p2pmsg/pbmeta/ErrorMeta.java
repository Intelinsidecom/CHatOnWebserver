package com.coolots.p2pmsg.pbmeta;

import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class ErrorMeta extends ProtoBufMetaBase {
    public ErrorMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SvcCode", 1, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("MsgCode", 2, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("MsgKey", 3, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo(Config.EXTRA_ERROR_CODE, 4, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("ErrorMsg", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ResponseCode", 6, true, String.class));
    }
}
