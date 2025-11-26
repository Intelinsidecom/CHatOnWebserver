package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.ConferenceInfo;
import java.util.Date;

/* loaded from: classes.dex */
public class RegionJoinConferenceRepMeta extends ProtoBufMetaBase {
    public RegionJoinConferenceRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceInfo", 1, true, ConferenceInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConnectCount", 2, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallerUserNo", 3, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallerUserId", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallerDeviceId", 5, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("StartTime", 6, true, Date.class));
    }
}
