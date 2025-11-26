package com.coolots.p2pmsg.pbmeta;

import com.google.protobuf.ByteString;

/* loaded from: classes.dex */
public class PushNotificationAskMeta extends ProtoBufMetaBase {
    public PushNotificationAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderUserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderDeviceID", 2, true, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserNo", 3, true, Long.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserID", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverDeviceID", 5, true, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushKey", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushType", 7, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("nestedMsgHeader", 8, true, ByteString.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("nestedMsgBody", 9, true, ByteString.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushGuaranteeType", 10, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushGuaranteeKey", 11, true, String.class));
    }
}
