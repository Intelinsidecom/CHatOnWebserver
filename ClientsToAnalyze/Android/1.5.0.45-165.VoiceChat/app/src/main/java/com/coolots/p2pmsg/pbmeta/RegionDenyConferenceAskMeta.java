package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class RegionDenyConferenceAskMeta extends ProtoBufMetaBase {
    public RegionDenyConferenceAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 3, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceId", 4, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PrivateIp", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserName", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RejectedMessage", 7, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CellularNetwork", 8, false, Short.class));
    }
}
