package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.PaidSvcPolicyInfo;
import java.util.List;

/* loaded from: classes.dex */
public class StoreSIMInfoRepMeta extends ProtoBufMetaBase {
    public StoreSIMInfoRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("PaidSvcPolicyList", 1, false, List.class, PaidSvcPolicyInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PayView", 2, false, Boolean.TYPE));
    }
}
