package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.MemberSimpleInfo;

/* loaded from: classes.dex */
public class CallPresenceInfoMeta extends ProtoBufMetaBase {
    public CallPresenceInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("MemberSimpleInfo", 1, true, MemberSimpleInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Presence", 2, true, String.class));
    }
}
