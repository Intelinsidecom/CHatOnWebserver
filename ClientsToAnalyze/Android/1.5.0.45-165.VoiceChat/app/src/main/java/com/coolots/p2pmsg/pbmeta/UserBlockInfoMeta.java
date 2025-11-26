package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class UserBlockInfoMeta extends ProtoBufMetaBase {
    public UserBlockInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ToID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UpdateDate", 2, true, Date.class));
    }
}
