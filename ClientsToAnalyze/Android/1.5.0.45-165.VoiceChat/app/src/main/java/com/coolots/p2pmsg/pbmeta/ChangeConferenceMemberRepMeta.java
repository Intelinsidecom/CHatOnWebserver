package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import java.util.List;

/* loaded from: classes.dex */
public class ChangeConferenceMemberRepMeta extends ProtoBufMetaBase {
    public ChangeConferenceMemberRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("OldUserInfoList", 2, true, List.class, SimpleUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NewUserInfoList", 3, true, List.class, SimpleUserInfo.class));
    }
}
