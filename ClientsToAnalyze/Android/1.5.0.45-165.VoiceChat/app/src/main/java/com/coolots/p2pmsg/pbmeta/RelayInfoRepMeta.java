package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.Server;
import java.util.List;

/* loaded from: classes.dex */
public class RelayInfoRepMeta extends ProtoBufMetaBase {
    public RelayInfoRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("Items", 1, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Servers", 2, true, List.class, Server.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DNSIP", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SIPDomainName", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SIPPort", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SIPBrokerIP", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SIPBrokerPort", 7, true, String.class));
    }
}
