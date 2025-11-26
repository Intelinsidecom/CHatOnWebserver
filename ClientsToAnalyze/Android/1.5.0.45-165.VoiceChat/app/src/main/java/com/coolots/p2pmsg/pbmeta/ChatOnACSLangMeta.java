package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class ChatOnACSLangMeta extends ProtoBufMetaBase {
    public ChatOnACSLangMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("LangCode", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("LangName", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CountryCode", 3, false, Integer.class));
    }
}
