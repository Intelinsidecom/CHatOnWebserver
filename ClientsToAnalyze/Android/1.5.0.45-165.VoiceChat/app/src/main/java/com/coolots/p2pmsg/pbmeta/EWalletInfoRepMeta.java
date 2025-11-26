package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.EWalletInfo;
import java.util.List;

/* loaded from: classes.dex */
public class EWalletInfoRepMeta extends ProtoBufMetaBase {
    public EWalletInfoRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("EWalletInfoList", 1, false, List.class, EWalletInfo.class));
    }
}
