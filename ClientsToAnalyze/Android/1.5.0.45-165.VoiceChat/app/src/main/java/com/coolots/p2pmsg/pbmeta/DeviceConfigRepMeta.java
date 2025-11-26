package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.DeviceConfigInfo;
import java.util.List;

/* loaded from: classes.dex */
public class DeviceConfigRepMeta extends ProtoBufMetaBase {
    public DeviceConfigRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceConfigInfoList", 1, false, List.class, DeviceConfigInfo.class));
    }
}
