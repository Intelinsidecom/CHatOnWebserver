package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.PhoneBookInfo;
import java.util.List;

/* loaded from: classes.dex */
public class AutoBuddyAskMeta extends ProtoBufMetaBase {
    public AutoBuddyAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneBookInfoList", 1, true, List.class, PhoneBookInfo.class));
    }
}
