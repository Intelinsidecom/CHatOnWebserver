package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.PushResult;
import java.util.List;

/* loaded from: classes.dex */
public class PushMultiNotificationRepMeta extends ProtoBufMetaBase {
    public PushMultiNotificationRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("PushResultList", 1, true, List.class, PushResult.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PushKey", 2, true, String.class));
    }
}
