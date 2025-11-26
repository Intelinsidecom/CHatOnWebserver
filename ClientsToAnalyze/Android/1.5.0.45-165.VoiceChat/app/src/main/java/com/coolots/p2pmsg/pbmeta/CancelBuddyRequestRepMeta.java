package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.ToID;
import java.util.List;

/* loaded from: classes.dex */
public class CancelBuddyRequestRepMeta extends ProtoBufMetaBase {
    public CancelBuddyRequestRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ToIDList", 1, true, List.class, ToID.class));
    }
}
