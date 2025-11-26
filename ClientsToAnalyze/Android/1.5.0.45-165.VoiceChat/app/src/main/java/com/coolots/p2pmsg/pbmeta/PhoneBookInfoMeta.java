package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class PhoneBookInfoMeta extends ProtoBufMetaBase {
    public PhoneBookInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("CountryCode", 1, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneNo", 2, true, String.class));
    }
}
