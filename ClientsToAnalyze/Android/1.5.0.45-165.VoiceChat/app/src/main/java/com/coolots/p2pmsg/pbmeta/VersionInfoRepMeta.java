package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.URL;
import java.util.List;

/* loaded from: classes.dex */
public class VersionInfoRepMeta extends ProtoBufMetaBase {
    public VersionInfoRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("Result", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("LatestVersion", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UpdateUrl", 3, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DownloadUrlList", 4, false, List.class, URL.class));
    }
}
