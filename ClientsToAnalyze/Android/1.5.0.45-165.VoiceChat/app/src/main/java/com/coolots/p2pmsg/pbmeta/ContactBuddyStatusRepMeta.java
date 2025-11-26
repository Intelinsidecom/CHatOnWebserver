package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.BuddyStatusInfo;
import java.util.List;

/* loaded from: classes.dex */
public class ContactBuddyStatusRepMeta extends ProtoBufMetaBase {
    public ContactBuddyStatusRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddyStatusInfoList", 1, true, List.class, BuddyStatusInfo.class));
    }
}
