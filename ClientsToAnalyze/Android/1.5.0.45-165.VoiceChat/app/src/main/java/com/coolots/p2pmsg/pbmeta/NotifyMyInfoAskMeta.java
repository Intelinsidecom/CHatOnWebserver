package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.UserInfo;

/* loaded from: classes.dex */
public class NotifyMyInfoAskMeta extends ProtoBufMetaBase {
    public NotifyMyInfoAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserInfo", 1, true, UserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SharedID", 2, true, String.class));
    }
}
