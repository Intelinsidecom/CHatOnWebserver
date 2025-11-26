package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class ScaleOutInfoRepMeta extends ProtoBufMetaBase {
    public ScaleOutInfoRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("serverType", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("serverNo", 2, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("returnValue", 3, false, String.class));
    }
}
