package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.ParticipantInfo;
import java.util.List;

/* loaded from: classes.dex */
public class RegionSubBatchConferenceAskMeta extends ProtoBufMetaBase {
    public RegionSubBatchConferenceAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ParticipantInfoList", 1, true, List.class, ParticipantInfo.class));
    }
}
