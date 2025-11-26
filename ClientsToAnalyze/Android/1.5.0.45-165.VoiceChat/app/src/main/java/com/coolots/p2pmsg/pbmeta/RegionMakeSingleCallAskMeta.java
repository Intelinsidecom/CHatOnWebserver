package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.P2PUserInfo;
import java.util.Date;

/* loaded from: classes.dex */
public class RegionMakeSingleCallAskMeta extends ProtoBufMetaBase {
    public RegionMakeSingleCallAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderUserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderUserID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderDeviceID", 3, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderGroupCode", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserID", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SrcUserInfo", 6, true, P2PUserInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("P2PKey", 7, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrID", 8, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StartDate", 9, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SenderEmail", 10, true, String.class));
    }
}
