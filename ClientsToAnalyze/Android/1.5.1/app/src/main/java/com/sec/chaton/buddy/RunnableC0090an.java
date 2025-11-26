package com.sec.chaton.buddy;

/* renamed from: com.sec.chaton.buddy.an */
/* loaded from: classes.dex */
class RunnableC0090an implements Runnable {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupEditAdapter f629a;

    RunnableC0090an(BuddyGroupEditAdapter buddyGroupEditAdapter) {
        this.f629a = buddyGroupEditAdapter;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f629a.f543o.smoothScrollTo(this.f629a.f543o.getChildAt(0).getWidth(), 0);
    }
}
