package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class NoteInfoMeta extends ProtoBufMetaBase {
    public NoteInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("FromUserID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NoteNo", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NoteType", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Contents", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("InsertDate", 5, true, Date.class));
    }
}
