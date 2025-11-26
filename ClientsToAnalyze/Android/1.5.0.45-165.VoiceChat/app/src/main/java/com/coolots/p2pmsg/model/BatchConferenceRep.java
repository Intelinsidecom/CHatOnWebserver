package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class BatchConferenceRep extends MsgBody {
    private int BatchConferenceCount;
    private int BatchConferenceParticipants;

    public int getBatchConferenceCount() {
        return this.BatchConferenceCount;
    }

    public void setBatchConferenceCount(int batchConferenceCount) {
        this.BatchConferenceCount = batchConferenceCount;
    }

    public int getBatchConferenceParticipants() {
        return this.BatchConferenceParticipants;
    }

    public void setBatchConferenceParticipants(int batchConferenceParticipants) {
        this.BatchConferenceParticipants = batchConferenceParticipants;
    }
}
