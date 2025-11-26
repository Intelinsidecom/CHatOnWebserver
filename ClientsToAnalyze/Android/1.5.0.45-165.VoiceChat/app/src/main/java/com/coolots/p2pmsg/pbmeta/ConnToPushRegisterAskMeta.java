package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class ConnToPushRegisterAskMeta extends ProtoBufMetaBase {
    public ConnToPushRegisterAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ServerID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ServerOrder", 2, true, Integer.class));
    }
}
