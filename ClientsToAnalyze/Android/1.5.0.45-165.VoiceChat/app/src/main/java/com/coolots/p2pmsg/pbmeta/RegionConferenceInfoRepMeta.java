package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import java.util.List;

/* loaded from: classes.dex */
public class RegionConferenceInfoRepMeta extends ProtoBufMetaBase {
    public RegionConferenceInfoRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SimpleUserInfoList", 1, true, List.class, SimpleUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceType", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PresenterUserID", 3, false, String.class));
    }
}
