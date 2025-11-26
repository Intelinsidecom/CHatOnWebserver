package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class NotifyConsentAskMeta extends ProtoBufMetaBase {
    public NotifyConsentAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("callSessionID", 1, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("conferenceNo", 2, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("consentType", 3, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("option", 4, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("accept", 5, true, Boolean.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("canceledByTimer", 6, false, Boolean.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("requestKey", 7, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("rejectUserID", 8, false, String.class));
    }
}
