package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import java.util.List;

/* loaded from: classes.dex */
public class RegionAddConferenceMemberRepMeta extends ProtoBufMetaBase {
    public RegionAddConferenceMemberRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SimpleUserInfoList", 2, true, List.class, SimpleUserInfo.class));
    }
}
