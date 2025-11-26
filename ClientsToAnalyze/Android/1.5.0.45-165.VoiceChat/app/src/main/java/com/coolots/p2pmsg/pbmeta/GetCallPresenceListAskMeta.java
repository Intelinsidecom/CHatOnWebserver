package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.MemberSimpleInfo;
import java.util.List;

/* loaded from: classes.dex */
public class GetCallPresenceListAskMeta extends ProtoBufMetaBase {
    public GetCallPresenceListAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("MemberSimpleInfoList", 1, true, List.class, MemberSimpleInfo.class));
    }
}
