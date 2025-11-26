package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.EWalletInfo;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import java.util.List;

/* loaded from: classes.dex */
public class AddConferenceMemberRepMeta extends ProtoBufMetaBase {
    public AddConferenceMemberRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SimpleUserInfoList", 2, true, List.class, SimpleUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("EWalletInfoList", 3, false, List.class, EWalletInfo.class));
    }
}
