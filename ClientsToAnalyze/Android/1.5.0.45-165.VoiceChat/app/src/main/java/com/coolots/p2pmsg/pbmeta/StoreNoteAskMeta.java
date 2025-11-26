package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.ToID;
import java.util.List;

/* loaded from: classes.dex */
public class StoreNoteAskMeta extends ProtoBufMetaBase {
    public StoreNoteAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("RoomNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NoteNo", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NoteType", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Contents", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ToIDList", 5, true, List.class, ToID.class));
    }
}
