package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.ConferenceMember;
import java.util.List;

/* loaded from: classes.dex */
public class ReqAddConferenceMemberRepMeta extends ProtoBufMetaBase {
    public ReqAddConferenceMemberRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("CallSessionID", 1, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceMemberList", 2, false, List.class, ConferenceMember.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Result", 3, false, String.class));
    }
}
