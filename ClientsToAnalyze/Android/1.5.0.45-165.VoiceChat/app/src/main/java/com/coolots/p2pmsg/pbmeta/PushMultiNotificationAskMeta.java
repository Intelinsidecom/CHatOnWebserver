package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.PushTargetInfo;
import com.google.protobuf.ByteString;
import java.util.List;

/* loaded from: classes.dex */
public class PushMultiNotificationAskMeta extends ProtoBufMetaBase {
    public PushMultiNotificationAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderUserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderDeviceID", 2, true, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushTargetInfoList", 3, true, List.class, PushTargetInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushType", 4, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushKey", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NestedMsgHeader", 6, true, ByteString.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NestedMsgBody", 7, true, ByteString.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushGuaranteeType", 8, true, Integer.TYPE));
    }
}
