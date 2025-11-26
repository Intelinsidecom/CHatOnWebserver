package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.InetAddr;

/* loaded from: classes.dex */
public class EngineLoginAskMeta extends ProtoBufMetaBase {
    public EngineLoginAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("NetType", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PrivateAddr", 2, true, InetAddr.class));
    }
}
