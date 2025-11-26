package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class MessageMeta extends ProtoBufMetaBase {
    public MessageMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("MessageName", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("OppositeSite", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Direction", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DateTime", 1, true, Date.class));
    }
}
