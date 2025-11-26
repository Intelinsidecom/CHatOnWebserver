package com.sec.chaton.buddy;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.dq */
/* loaded from: classes.dex */
class RunnableC1256dq implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1255dp f4761a;

    RunnableC1256dq(C1255dp c1255dp) {
        this.f4761a = c1255dp;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4761a.f4760d.f3622aC.getChildAt(0) != null) {
            this.f4761a.f4760d.f3622aC.smoothScrollTo(this.f4761a.f4760d.f3622aC.getChildAt(0).getWidth(), 0);
        }
    }
}
