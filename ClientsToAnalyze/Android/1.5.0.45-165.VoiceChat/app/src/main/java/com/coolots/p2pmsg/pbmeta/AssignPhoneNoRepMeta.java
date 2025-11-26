package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class AssignPhoneNoRepMeta extends ProtoBufMetaBase {
    public AssignPhoneNoRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SipID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SipPw", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ProxyIP", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ProxyPort", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ProxyDomainName", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ProxyConnType", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("BSIP", 7, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("BSPort", 8, true, String.class));
    }
}
