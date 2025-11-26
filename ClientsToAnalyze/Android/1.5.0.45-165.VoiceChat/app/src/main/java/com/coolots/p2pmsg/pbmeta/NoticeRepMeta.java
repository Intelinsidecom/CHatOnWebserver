package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.NoticeInfo;
import java.util.List;

/* loaded from: classes.dex */
public class NoticeRepMeta extends ProtoBufMetaBase {
    public NoticeRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("NoticeInfoList", 1, true, List.class, NoticeInfo.class));
    }
}
