package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.ConfigInfo;
import java.util.List;

/* loaded from: classes.dex */
public class ScaleOutInfoAskMeta extends ProtoBufMetaBase {
    public ScaleOutInfoAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("serverType", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("serverNo", 2, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("service", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("serverConfig", 4, true, List.class, ConfigInfo.class));
    }
}
