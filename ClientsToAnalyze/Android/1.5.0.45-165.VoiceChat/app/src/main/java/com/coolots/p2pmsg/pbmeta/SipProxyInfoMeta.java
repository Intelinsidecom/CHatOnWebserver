package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class SipProxyInfoMeta extends ProtoBufMetaBase {
    public SipProxyInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ProxyAddr", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ProxyPort", 2, true, Integer.TYPE));
    }
}
