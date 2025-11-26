package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class SAUserInfoAskMeta extends ProtoBufMetaBase {
    public SAUserInfoAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SamsungAccountID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AppID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AccessToken", 3, true, String.class));
    }
}
