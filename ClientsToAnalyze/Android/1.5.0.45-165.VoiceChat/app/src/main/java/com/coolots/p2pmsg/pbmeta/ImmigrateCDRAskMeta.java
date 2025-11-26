package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.CdrReceiveDump;
import com.coolots.p2pmsg.model.CdrSendCalleeDump;
import com.coolots.p2pmsg.model.CdrSendDump;
import java.util.List;

/* loaded from: classes.dex */
public class ImmigrateCDRAskMeta extends ProtoBufMetaBase {
    public ImmigrateCDRAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrSendDumpList", 1, false, List.class, CdrSendDump.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrSendCalleeDumpList", 2, false, List.class, CdrSendCalleeDump.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrReceiveDumpList", 3, false, List.class, CdrReceiveDump.class));
    }
}
