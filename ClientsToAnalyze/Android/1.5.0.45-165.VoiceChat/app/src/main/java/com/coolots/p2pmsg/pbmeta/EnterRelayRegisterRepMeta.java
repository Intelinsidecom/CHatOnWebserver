package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.URL;
import com.sec.spp.push.Config;
import java.util.List;

/* loaded from: classes.dex */
public class EnterRelayRegisterRepMeta extends ProtoBufMetaBase {
    public EnterRelayRegisterRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("PushKey", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PublicIP", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PublicPort", 3, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo(Config.EXTRA_ERROR_CODE, 4, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Result", 5, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("LatestVersion", 6, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DownloadUrlList", 7, false, List.class, URL.class));
    }
}
