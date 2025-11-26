package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class UpdateConferenceMemberStatusRep extends MsgBody {
    private int UpdateConferenceCount;
    private int UpdateConferenceMember;

    public int getUpdateConferenceCount() {
        return this.UpdateConferenceCount;
    }

    public void setUpdateConferenceCount(int updateConferenceCount) {
        this.UpdateConferenceCount = updateConferenceCount;
    }

    public int getUpdateConferenceMember() {
        return this.UpdateConferenceMember;
    }

    public void setUpdateConferenceMember(int updateConferenceMember) {
        this.UpdateConferenceMember = updateConferenceMember;
    }
}
