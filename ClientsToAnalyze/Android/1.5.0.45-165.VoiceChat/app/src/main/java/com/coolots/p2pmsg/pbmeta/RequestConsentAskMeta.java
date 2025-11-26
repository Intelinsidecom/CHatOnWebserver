package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class RequestConsentAskMeta extends ProtoBufMetaBase {
    public RequestConsentAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("callSessionID", 1, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("conferenceNo", 2, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("requesterID", 3, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("consentType", 4, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("option", 5, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("accept", 6, false, Boolean.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("canceledByTimer", 7, false, Boolean.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("requestKey", 8, false, Integer.TYPE));
    }
}
