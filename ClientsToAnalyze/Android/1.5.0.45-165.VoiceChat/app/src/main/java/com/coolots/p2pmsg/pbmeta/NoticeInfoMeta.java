package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class NoticeInfoMeta extends ProtoBufMetaBase {
    public NoticeInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("NoticeNo", 1, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Title", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Content", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("InsertDate", 4, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UpdateDate", 5, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ExpireDate", 6, true, Date.class));
    }
}
