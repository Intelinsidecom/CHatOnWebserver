package com.sec.chaton.userprofile;

import com.sec.chaton.database.task.AbstractQueryTask;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.userprofile.ax */
/* loaded from: classes.dex */
class C0570ax implements AbstractQueryTask.OnQueryTaskResult {

    /* renamed from: a */
    final /* synthetic */ RelationshipRank2 f3550a;

    C0570ax(RelationshipRank2 relationshipRank2) {
        this.f3550a = relationshipRank2;
    }

    @Override // com.sec.chaton.database.task.AbstractQueryTask.OnQueryTaskResult
    /* renamed from: a */
    public void mo654a(int i, boolean z, Object obj) {
        this.f3550a.f3373e.dismiss();
        if (!z) {
            ChatONLogWriter.m3506b("Query Result NOK...", getClass().getSimpleName());
        } else {
            ChatONLogWriter.m3506b("Query Result OK. refreshTime=" + this.f3550a.f3380m, getClass().getSimpleName());
            this.f3550a.m3344e();
        }
    }
}
