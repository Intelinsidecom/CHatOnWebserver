package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class UserInfoMeta extends ProtoBufMetaBase {
    public UserInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserStatus", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ImageInfoChange", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ChatName", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("IsChatInput", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("IsFSUsable", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("IsSvrAskNewInfo", 7, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SystemInfo", 8, true, String.class));
    }
}
