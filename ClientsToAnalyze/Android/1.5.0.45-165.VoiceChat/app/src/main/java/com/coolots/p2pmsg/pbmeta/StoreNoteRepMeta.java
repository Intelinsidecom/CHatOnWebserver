package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class StoreNoteRepMeta extends ProtoBufMetaBase {
    public StoreNoteRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("RoomNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NoteNo", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("InsertDate", 3, true, Date.class));
    }
}
