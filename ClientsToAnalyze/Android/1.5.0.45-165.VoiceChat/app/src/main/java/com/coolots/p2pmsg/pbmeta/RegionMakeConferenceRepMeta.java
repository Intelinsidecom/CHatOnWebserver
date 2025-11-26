package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import java.util.List;

/* loaded from: classes.dex */
public class RegionMakeConferenceRepMeta extends ProtoBufMetaBase {
    public RegionMakeConferenceRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SimpleUserInfoList", 1, true, List.class, SimpleUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UnknownUserInfoList", 2, true, List.class, SimpleUserInfo.class));
    }
}
