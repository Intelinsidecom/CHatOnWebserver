package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.UserBlockInfo;
import java.util.List;

/* loaded from: classes.dex */
public class UserBlockListRepMeta extends ProtoBufMetaBase {
    public UserBlockListRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserBlockInfoList", 1, true, List.class, UserBlockInfo.class));
    }
}
