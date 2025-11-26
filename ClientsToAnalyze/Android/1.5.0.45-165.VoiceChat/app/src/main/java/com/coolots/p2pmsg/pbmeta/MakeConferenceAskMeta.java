package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.google.protobuf.ByteString;
import java.util.List;

/* loaded from: classes.dex */
public class MakeConferenceAskMeta extends ProtoBufMetaBase {
    public MakeConferenceAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SimpleUserInfoList", 1, true, List.class, SimpleUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VideoConference", 2, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CellularNetwork", 3, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PKey", 4, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceType", 5, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("EventID", 6, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AppVersion", 7, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AppId", 8, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("FeatureSet", 9, false, ByteString.class));
    }
}
