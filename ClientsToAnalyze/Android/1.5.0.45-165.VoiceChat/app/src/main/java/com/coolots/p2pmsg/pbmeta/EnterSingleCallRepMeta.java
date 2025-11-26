package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.URL;
import java.util.List;

/* loaded from: classes.dex */
public class EnterSingleCallRepMeta extends ProtoBufMetaBase {
    public EnterSingleCallRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("PushKey", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Result", 2, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("LatestVersion", 3, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DownloadUrlList", 4, false, List.class, URL.class));
    }
}
