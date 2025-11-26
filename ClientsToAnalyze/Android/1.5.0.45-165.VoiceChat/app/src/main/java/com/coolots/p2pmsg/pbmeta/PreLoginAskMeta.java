package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.DeviceIDAsk;
import com.coolots.p2pmsg.model.ServerInfoAsk;

/* loaded from: classes.dex */
public class PreLoginAskMeta extends ProtoBufMetaBase {
    public PreLoginAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ServerInfoAsk", 1, true, ServerInfoAsk.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceIDAsk", 2, true, DeviceIDAsk.class));
    }
}
