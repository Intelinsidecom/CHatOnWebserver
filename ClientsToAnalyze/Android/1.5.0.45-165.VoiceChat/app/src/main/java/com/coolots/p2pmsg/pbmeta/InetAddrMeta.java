package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class InetAddrMeta extends ProtoBufMetaBase {
    public InetAddrMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("IP", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Port", 2, true, Integer.TYPE));
    }
}
