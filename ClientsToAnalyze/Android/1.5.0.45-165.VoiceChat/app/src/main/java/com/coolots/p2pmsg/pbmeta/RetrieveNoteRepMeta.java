package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.RoomInfo;
import java.util.List;

/* loaded from: classes.dex */
public class RetrieveNoteRepMeta extends ProtoBufMetaBase {
    public RetrieveNoteRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("RoomList", 1, true, List.class, RoomInfo.class));
    }
}
