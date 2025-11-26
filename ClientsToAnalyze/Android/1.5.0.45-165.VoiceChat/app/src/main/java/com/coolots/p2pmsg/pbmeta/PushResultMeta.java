package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.PushTargetInfo;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class PushResultMeta extends ProtoBufMetaBase {
    public PushResultMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo(Config.EXTRA_ERROR_CODE, 1, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushTarget", 2, true, PushTargetInfo.class));
    }
}
