package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class NationalPhoneCodeMeta extends ProtoBufMetaBase {
    public NationalPhoneCodeMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("NationalCode", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NationalNameKor", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NationalNameEng", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CountryCode", 4, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Iso2Code", 5, true, String.class));
    }
}
