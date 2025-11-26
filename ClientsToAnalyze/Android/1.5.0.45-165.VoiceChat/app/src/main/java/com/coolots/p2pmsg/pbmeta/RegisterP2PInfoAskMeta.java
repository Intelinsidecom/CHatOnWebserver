package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.P2PUserInfo;

/* loaded from: classes.dex */
public class RegisterP2PInfoAskMeta extends ProtoBufMetaBase {
    public RegisterP2PInfoAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PUserInfo", 2, true, P2PUserInfo.class));
    }
}
