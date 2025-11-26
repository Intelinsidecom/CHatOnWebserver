package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class DeviceIDRepMeta extends ProtoBufMetaBase {
    public DeviceIDRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceID", 1, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Nonce", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NonceValidateTime", 3, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AppVersion", 4, false, String.class));
    }
}
