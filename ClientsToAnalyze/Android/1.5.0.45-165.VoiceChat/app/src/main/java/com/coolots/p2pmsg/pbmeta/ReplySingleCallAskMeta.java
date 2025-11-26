package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.ToDeviceID;
import java.util.List;

/* loaded from: classes.dex */
public class ReplySingleCallAskMeta extends ProtoBufMetaBase {
    public ReplySingleCallAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverUserID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiverDeviceIDList", 3, true, List.class, ToDeviceID.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReplyingDeviceID", 4, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CellularNetwork", 5, false, Short.class));
    }
}
