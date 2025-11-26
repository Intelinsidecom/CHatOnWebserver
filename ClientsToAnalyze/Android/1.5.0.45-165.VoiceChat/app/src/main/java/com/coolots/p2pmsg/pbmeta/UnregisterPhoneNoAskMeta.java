package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.PhoneNoInfo;
import java.util.List;

/* loaded from: classes.dex */
public class UnregisterPhoneNoAskMeta extends ProtoBufMetaBase {
    public UnregisterPhoneNoAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneNoList", 1, false, List.class, PhoneNoInfo.class));
    }
}
