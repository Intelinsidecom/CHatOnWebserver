package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class SIPInfoMeta extends ProtoBufMetaBase {
    public SIPInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("BaseCountryCode", 2, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("BasePrefix", 3, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SIPDomain", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SIPPort", 5, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SIPPwd", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DNSSRV", 7, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PPSIP", 8, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PPSPort", 9, true, Integer.TYPE));
    }
}
