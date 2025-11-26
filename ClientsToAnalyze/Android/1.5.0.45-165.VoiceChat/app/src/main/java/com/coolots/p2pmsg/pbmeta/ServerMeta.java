package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class ServerMeta extends ProtoBufMetaBase {
    public ServerMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ServerType", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("IP", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Port", 3, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Priority", 4, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CipherKey", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SubPort", 6, true, Integer.class));
    }
}
