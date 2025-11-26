package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.Server;
import com.coolots.p2pmsg.model.ToDeviceID;
import com.coolots.p2pmsg.model.URL;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class MakeSingleCallRepMeta extends ProtoBufMetaBase {
    public MakeSingleCallRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("PushKey", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StartDate", 3, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ToDeviceIDList", 4, false, List.class, ToDeviceID.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Blocked", 5, false, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Servers", 6, false, List.class, Server.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Result", 7, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("LatestVersion", 8, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DownloadUrlList", 9, false, List.class, URL.class));
    }
}
