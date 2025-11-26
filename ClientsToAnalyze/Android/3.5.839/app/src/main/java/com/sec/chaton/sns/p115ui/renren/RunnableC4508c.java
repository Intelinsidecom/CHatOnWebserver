package com.sec.chaton.sns.p115ui.renren;

import com.sec.chaton.util.C4904y;

/* compiled from: RenrenSubMenuFragment.java */
/* renamed from: com.sec.chaton.sns.ui.renren.c */
/* loaded from: classes.dex */
class RunnableC4508c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C4507b f16242a;

    RunnableC4508c(C4507b c4507b) {
        this.f16242a = c4507b;
    }

    @Override // java.lang.Runnable
    public void run() {
        C4904y.m18639b("onComplete() \t- Login", RenrenSubMenuFragment.f16235g);
        this.f16242a.f16241a.m16913a(this.f16242a.f16241a.f16238j.mo16647b());
        this.f16242a.f16241a.m16920g();
        this.f16242a.f16241a.m17068j();
    }
}
