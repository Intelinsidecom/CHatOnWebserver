package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.MemberDeviceInfoDump;
import com.coolots.p2pmsg.model.MemberDump;
import java.util.List;

/* loaded from: classes.dex */
public class ImmigrateAskMeta extends ProtoBufMetaBase {
    public ImmigrateAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("FromRegion", 1, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("MemberDump", 2, true, MemberDump.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MemberDeviceInfoDumpList", 3, false, List.class, MemberDeviceInfoDump.class));
    }
}
