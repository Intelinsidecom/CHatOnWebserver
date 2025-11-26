package com.coolots.p2pmsg.pbmeta;

import com.google.protobuf.ByteString;

/* loaded from: classes.dex */
public class JoinConferenceAskMeta extends ProtoBufMetaBase {
    public JoinConferenceAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CellularNetwork", 2, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("FeatureSet", 3, false, ByteString.class));
    }
}
