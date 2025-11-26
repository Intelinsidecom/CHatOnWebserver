package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class UpdateServerStatusAskMeta extends ProtoBufMetaBase {
    public UpdateServerStatusAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ServerType", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ServerNo", 2, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Status", 3, true, String.class));
    }
}
