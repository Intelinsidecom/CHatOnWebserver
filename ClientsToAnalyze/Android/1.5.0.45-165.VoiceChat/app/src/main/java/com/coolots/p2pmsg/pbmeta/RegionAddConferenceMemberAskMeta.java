package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import java.util.List;

/* loaded from: classes.dex */
public class RegionAddConferenceMemberAskMeta extends ProtoBufMetaBase {
    public RegionAddConferenceMemberAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RequestUserID", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RequestUserNo", 4, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SimpleUserInfoList", 5, true, List.class, SimpleUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VideoConference", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PKey", 7, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("EventID", 8, false, String.class));
    }
}
