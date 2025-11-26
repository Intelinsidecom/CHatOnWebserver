package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class RegionSubCloseConferenceAskMeta extends ProtoBufMetaBase {
    public RegionSubCloseConferenceAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("EndTime", 2, false, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Duration", 3, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("WaitUserInfoList", 4, false, List.class, SimpleUserInfo.class));
    }
}
