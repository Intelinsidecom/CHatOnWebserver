package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.PhoneBookInfo;
import com.coolots.p2pmsg.model.ProfileInfo;
import java.util.List;

/* loaded from: classes.dex */
public class RegionAutoBuddyAskMeta extends ProtoBufMetaBase {
    public RegionAutoBuddyAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ProfileInfo", 1, true, ProfileInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneBookInfoList", 2, true, List.class, PhoneBookInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SamsungAccountID", 3, true, String.class));
    }
}
