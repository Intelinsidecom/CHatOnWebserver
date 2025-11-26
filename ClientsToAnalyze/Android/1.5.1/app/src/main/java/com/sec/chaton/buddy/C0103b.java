package com.sec.chaton.buddy;

import com.sec.chaton.database.task.AbstractQueryTask;

/* renamed from: com.sec.chaton.buddy.b */
/* loaded from: classes.dex */
class C0103b implements AbstractQueryTask.OnQueryTaskResult {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f646a;

    C0103b(BuddyFragment buddyFragment) {
        this.f646a = buddyFragment;
    }

    @Override // com.sec.chaton.database.task.AbstractQueryTask.OnQueryTaskResult
    /* renamed from: a */
    public void mo654a(int i, boolean z, Object obj) {
        if (this.f646a.getActivity() != null && z && i == 2) {
            this.f646a.getActivity().finish();
        }
    }
}
