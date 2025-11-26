package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import java.util.List;

/* loaded from: classes.dex */
public class RegionChangeConferenceMemberRepMeta extends ProtoBufMetaBase {
    public RegionChangeConferenceMemberRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("NewUserInfoList", 1, true, List.class, SimpleUserInfo.class));
    }
}
