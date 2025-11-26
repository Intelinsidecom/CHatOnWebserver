package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.DeviceIDRep;
import com.coolots.p2pmsg.model.ServerInfoRep;

/* loaded from: classes.dex */
public class PreLoginRepMeta extends ProtoBufMetaBase {
    public PreLoginRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ServerInfoRep", 1, true, ServerInfoRep.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceIDRep", 2, true, DeviceIDRep.class));
    }
}
