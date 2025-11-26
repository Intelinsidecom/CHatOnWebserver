package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.ConferenceInfo;
import com.coolots.p2pmsg.model.EWalletInfo;
import com.coolots.p2pmsg.model.Server;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.coolots.p2pmsg.model.URL;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class MakeConferenceRepMeta extends ProtoBufMetaBase {
    public MakeConferenceRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceInfo", 1, true, ConferenceInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StartTime", 2, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SimpleUserInfoList", 3, true, List.class, SimpleUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PKey", 4, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Result", 5, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("LatestVersion", 6, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Servers", 7, true, List.class, Server.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DownloadUrlList", 8, false, List.class, URL.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("EWalletInfoList", 9, false, List.class, EWalletInfo.class));
    }
}
