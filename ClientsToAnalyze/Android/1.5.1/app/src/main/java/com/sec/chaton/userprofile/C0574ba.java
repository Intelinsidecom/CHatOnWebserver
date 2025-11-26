package com.sec.chaton.userprofile;

import com.sec.chaton.database.task.RelationUpdateTask;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.userprofile.ba */
/* loaded from: classes.dex */
class C0574ba implements RelationUpdateTask.RelationUpdateStatus {

    /* renamed from: a */
    final /* synthetic */ RelationshipRank2 f3556a;

    C0574ba(RelationshipRank2 relationshipRank2) {
        this.f3556a = relationshipRank2;
    }

    @Override // com.sec.chaton.database.task.RelationUpdateTask.RelationUpdateStatus
    /* renamed from: a */
    public void mo2338a() {
        ChatONLogWriter.m3511e("onRelationUpdateCompleted.", getClass().getSimpleName());
        this.f3556a.f3374f.dismiss();
        this.f3556a.m3344e();
    }
}
