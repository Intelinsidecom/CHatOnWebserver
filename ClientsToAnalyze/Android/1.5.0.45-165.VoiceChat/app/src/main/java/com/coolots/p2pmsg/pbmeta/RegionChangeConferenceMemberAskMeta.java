package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import java.util.List;

/* loaded from: classes.dex */
public class RegionChangeConferenceMemberAskMeta extends ProtoBufMetaBase {
    public RegionChangeConferenceMemberAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("OldUserInfoList", 2, true, List.class, SimpleUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NewUserInfoList", 3, true, List.class, SimpleUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PKey", 4, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RequestUserID", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RequestUserNo", 6, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 7, true, String.class));
    }
}
