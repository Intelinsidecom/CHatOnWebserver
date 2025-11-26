package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RegionSubBatchConferenceAsk extends MsgBody {
    private List<ParticipantInfo> ParticipantInfoList = new ArrayList();

    public List<ParticipantInfo> getParticipantInfoList() {
        return this.ParticipantInfoList;
    }

    public void setParticipantInfoList(List<ParticipantInfo> participantInfoList) {
        this.ParticipantInfoList = participantInfoList;
    }
}
