package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class PushTargetInfoMeta extends ProtoBufMetaBase {
    public PushTargetInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserNo", 1, true, Long.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverDeviceID", 3, true, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushGuaranteeKey", 4, true, String.class));
    }
}
