package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.ToDeviceID;
import java.util.List;

/* loaded from: classes.dex */
public class RegionMakeSingleCallRepMeta extends ProtoBufMetaBase {
    public RegionMakeSingleCallRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ToDeviceIDList", 1, true, List.class, ToDeviceID.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserNo", 2, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Blocked", 3, true, Boolean.class));
    }
}
