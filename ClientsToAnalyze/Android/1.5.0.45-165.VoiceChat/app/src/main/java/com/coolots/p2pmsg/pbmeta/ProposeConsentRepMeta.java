package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class ProposeConsentRepMeta extends ProtoBufMetaBase {
    public ProposeConsentRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("callSessionID", 1, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("conferenceNo", 2, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("requestKey", 3, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("consentType", 4, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("option", 5, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("requestResult", 6, false, Boolean.TYPE));
    }
}
