package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.NoteInfo;
import java.util.List;

/* loaded from: classes.dex */
public class RoomInfoMeta extends ProtoBufMetaBase {
    public RoomInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("RoomNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NoteList", 2, true, List.class, NoteInfo.class));
    }
}
