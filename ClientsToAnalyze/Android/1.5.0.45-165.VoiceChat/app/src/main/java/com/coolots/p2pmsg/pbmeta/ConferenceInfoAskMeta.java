package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class ConferenceInfoAskMeta extends ProtoBufMetaBase {
    public ConferenceInfoAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AppVersion", 2, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AppId", 3, false, String.class));
    }
}
