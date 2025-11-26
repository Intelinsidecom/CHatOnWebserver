package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.Server;
import java.util.List;

/* loaded from: classes.dex */
public class ServerInfoRepMeta extends ProtoBufMetaBase {
    public ServerInfoRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("Servers", 1, true, List.class, Server.class));
    }
}
