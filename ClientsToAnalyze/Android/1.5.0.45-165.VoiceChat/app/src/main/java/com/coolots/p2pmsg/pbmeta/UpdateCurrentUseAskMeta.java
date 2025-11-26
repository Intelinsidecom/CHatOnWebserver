package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class UpdateCurrentUseAskMeta extends ProtoBufMetaBase {
    public UpdateCurrentUseAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("CurrentUse", 1, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("ServerType", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ServerNo", 3, true, Integer.TYPE));
    }
}
