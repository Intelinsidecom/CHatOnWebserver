package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class NotifyNoteAskMeta extends ProtoBufMetaBase {
    public NotifyNoteAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("RoomNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NoteNo", 2, true, Long.class));
    }
}
