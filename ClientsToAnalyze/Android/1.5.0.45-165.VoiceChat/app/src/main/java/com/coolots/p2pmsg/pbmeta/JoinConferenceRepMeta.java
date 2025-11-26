package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.ConferenceInfo;
import com.coolots.p2pmsg.model.Server;
import java.util.List;

/* loaded from: classes.dex */
public class JoinConferenceRepMeta extends ProtoBufMetaBase {
    public JoinConferenceRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceInfo", 1, true, ConferenceInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Servers", 2, true, List.class, Server.class));
    }
}
