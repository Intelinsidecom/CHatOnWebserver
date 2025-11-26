package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.PartyDeviceInfo;

/* loaded from: classes.dex */
public class PartyInfoRepMeta extends ProtoBufMetaBase {
    public PartyInfoRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("PartyUserID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PartyUserNo", 2, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PartyDeviceInfoList", 3, true, PartyDeviceInfo.class));
    }
}
