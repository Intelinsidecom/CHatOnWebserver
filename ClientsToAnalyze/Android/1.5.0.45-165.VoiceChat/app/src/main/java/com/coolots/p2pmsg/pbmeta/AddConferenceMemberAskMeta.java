package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import java.util.List;

/* loaded from: classes.dex */
public class AddConferenceMemberAskMeta extends ProtoBufMetaBase {
    public AddConferenceMemberAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SimpleUserInfoList", 2, true, List.class, SimpleUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VideoConference", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PKey", 4, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("EventID", 5, false, String.class));
    }
}
