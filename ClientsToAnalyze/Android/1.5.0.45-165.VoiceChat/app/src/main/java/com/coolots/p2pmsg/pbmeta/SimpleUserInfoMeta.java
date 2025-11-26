package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.P2PUserInfo;
import com.coolots.p2pmsg.model.ToDeviceID;
import com.google.protobuf.ByteString;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class SimpleUserInfoMeta extends ProtoBufMetaBase {
    public SimpleUserInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserName", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserType", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Status", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 5, true, Long.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceID", 6, true, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RejectedMessage", 7, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ToDeviceIDList", 8, false, List.class, ToDeviceID.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushDisableYn", 9, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("HoldYn", 10, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RegionCode", 11, false, Byte.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneNo", 12, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PUserInfo", 13, false, P2PUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("InviteUserID", 14, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MuteVideoYn", 15, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MuteAudioYn", 16, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StartTime", 17, false, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("FeatureSet", 18, false, ByteString.class));
    }
}
