package com.sec.chaton.buddy;

/* renamed from: com.sec.chaton.buddy.r */
/* loaded from: classes.dex */
class RunnableC0125r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ BuddyAdapter f707a;

    RunnableC0125r(BuddyAdapter buddyAdapter) {
        this.f707a = buddyAdapter;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f707a.f398p.smoothScrollTo(this.f707a.f398p.getChildAt(0).getWidth(), 0);
    }
}
