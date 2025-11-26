package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class NotifyFinishShareCameraAskMeta extends ProtoBufMetaBase {
    public NotifyFinishShareCameraAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("callSessionID", 1, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("conferenceNo", 2, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("endReason", 3, false, Integer.TYPE));
    }
}
