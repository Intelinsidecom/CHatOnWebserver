package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.ConfLimitPolicyInfo;
import com.coolots.p2pmsg.model.EWalletInfo;
import com.coolots.p2pmsg.model.PaidSvcPolicyInfo;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class NonceRepMeta extends ProtoBufMetaBase {
    public NonceRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("Nonce", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NonceValidateTime", 2, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AppVersion", 3, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("EWalletInfoList", 4, false, List.class, EWalletInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PaidSvcPolicyList", 5, false, List.class, PaidSvcPolicyInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConfLimitPolicyList", 6, false, List.class, ConfLimitPolicyInfo.class));
    }
}
