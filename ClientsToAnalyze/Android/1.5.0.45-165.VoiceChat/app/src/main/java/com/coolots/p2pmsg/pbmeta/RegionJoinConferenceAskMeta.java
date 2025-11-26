package com.coolots.p2pmsg.pbmeta;

import com.google.protobuf.ByteString;

/* loaded from: classes.dex */
public class RegionJoinConferenceAskMeta extends ProtoBufMetaBase {
    public RegionJoinConferenceAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 3, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceId", 4, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PrivateIp", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserName", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CellularNetwork", 7, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("FeatureSet", 8, false, ByteString.class));
    }
}
