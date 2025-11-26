package com.coolots.p2pmsg.pbmeta;

import com.google.protobuf.ByteString;

/* loaded from: classes.dex */
public class NotifyBoardDataAskMeta extends ProtoBufMetaBase {
    public NotifyBoardDataAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CallSessionID", 2, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SrcUserID", 3, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("BoardType", 4, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Contents", 5, false, ByteString.class));
    }
}
