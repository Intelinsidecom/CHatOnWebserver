package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.ConfLimitPolicyInfo;
import com.coolots.p2pmsg.model.EWalletInfo;
import com.coolots.p2pmsg.model.PaidSvcPolicyInfo;
import java.util.List;

/* loaded from: classes.dex */
public class LoginRepMeta extends ProtoBufMetaBase {
    public LoginRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("CipherKey", 2, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SessionID", 3, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("EWalletInfoList", 4, false, List.class, EWalletInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PaidSvcPolicyList", 5, false, List.class, PaidSvcPolicyInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConfLimitPolicyList", 6, false, List.class, ConfLimitPolicyInfo.class));
    }
}
