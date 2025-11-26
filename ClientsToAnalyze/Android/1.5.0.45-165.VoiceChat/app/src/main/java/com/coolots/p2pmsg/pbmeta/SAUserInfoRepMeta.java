package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class SAUserInfoRepMeta extends ProtoBufMetaBase {
    public SAUserInfoRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SamsungAccountID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CountryCode2", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CountryCode3", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("FamilyName", 4, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("GivenName", 5, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Birthdate", 6, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("LoginID", 7, true, String.class));
    }
}
