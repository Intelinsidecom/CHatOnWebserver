package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.Message;
import com.vlingo.sdk.internal.audio.TTSRequestParams;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class MessageReportAskMeta extends ProtoBufMetaBase {
    public MessageReportAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo(TTSRequestParams.TYPE, 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ClientCurrentTime", 1, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MessageList", 1, true, List.class, Message.class));
    }
}
