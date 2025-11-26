package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class ServerKeyAskMeta extends ProtoBufMetaBase {
    public ServerKeyAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ServerType", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ServerNo", 2, true, Integer.TYPE));
    }
}
