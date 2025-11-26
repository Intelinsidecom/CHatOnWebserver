package com.sec.chaton.buddy;

/* compiled from: BuddyGroupEditAdapter.java */
/* renamed from: com.sec.chaton.buddy.cj */
/* loaded from: classes.dex */
class RunnableC0325cj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0322cg f1462a;

    RunnableC0325cj(C0322cg c0322cg) {
        this.f1462a = c0322cg;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1462a.f1456o.smoothScrollTo(this.f1462a.f1456o.getChildAt(0).getWidth(), 0);
    }
}
