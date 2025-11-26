package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class ParticipantInfoMeta extends ProtoBufMetaBase {
    public ParticipantInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConfName", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 2, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConnectCount", 3, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserType", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceId", 5, true, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SipId", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StatusCode", 7, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("HoldYn", 8, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MuteVideoYn", 9, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MuteAudioYn", 10, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserName", 11, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserId", 12, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RegionCode", 13, true, Byte.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("StartTime", 14, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("EndTime", 15, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Duration", 16, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CellularNetwork", 17, true, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RejectedMessage", 18, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("InviteUserId", 19, true, String.class));
    }
}
