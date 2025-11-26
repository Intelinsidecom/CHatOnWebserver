package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.coolots.p2pmsg.model.URL;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class ConferenceInfoRepMeta extends ProtoBufMetaBase {
    public ConferenceInfoRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VideoConference", 2, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SimpleUserInfoList", 3, true, List.class, SimpleUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StartTime", 4, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceType", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PresenterUserID", 6, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Result", 7, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("LatestVersion", 8, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DownloadUrlList", 9, false, List.class, URL.class));
    }
}
