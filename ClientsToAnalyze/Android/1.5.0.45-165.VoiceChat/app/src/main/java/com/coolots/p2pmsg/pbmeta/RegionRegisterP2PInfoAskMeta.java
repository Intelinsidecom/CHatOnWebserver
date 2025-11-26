package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.P2PUserInfo;

/* loaded from: classes.dex */
public class RegionRegisterP2PInfoAskMeta extends ProtoBufMetaBase {
    public RegionRegisterP2PInfoAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PUserInfo", 2, true, P2PUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 3, true, String.class));
    }
}
