package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.CallPresenceInfo;
import java.util.List;

/* loaded from: classes.dex */
public class GetCallPresenceListRepMeta extends ProtoBufMetaBase {
    public GetCallPresenceListRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("CallPresenceInfoList", 1, true, List.class, CallPresenceInfo.class));
    }
}
