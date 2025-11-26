package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.MemberDeviceInfoDump;
import com.coolots.p2pmsg.model.MemberDump;
import java.util.List;

/* loaded from: classes.dex */
public class WantedRepMeta extends ProtoBufMetaBase {
    public WantedRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("MemberDump", 1, true, MemberDump.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MemberDeviceInfoDumpList", 2, false, List.class, MemberDeviceInfoDump.class));
    }
}
