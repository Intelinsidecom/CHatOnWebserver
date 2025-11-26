package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class RegionMakeConferenceAskMeta extends ProtoBufMetaBase {
    public RegionMakeConferenceAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConfName", 3, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConfKey", 4, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("InitConfType", 5, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConfType", 6, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("McuId", 7, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("McuSipId", 8, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StatusYn", 9, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StartTime", 10, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrId", 11, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RegionCode", 12, true, Byte.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SimpleUserInfoList", 13, true, List.class, SimpleUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderEmail", 14, true, String.class));
    }
}
