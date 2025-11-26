package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.util.C3250y;

/* compiled from: RenrenSubMenuFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.w */
/* loaded from: classes.dex */
class RunnableC2829w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2828v f10360a;

    RunnableC2829w(C2828v c2828v) {
        this.f10360a = c2828v;
    }

    @Override // java.lang.Runnable
    public void run() {
        C3250y.m11450b("onComplete() \t- Login", RenrenSubMenuFragment.f10054g);
        this.f10360a.f10359a.m9986a(this.f10360a.f10359a.f10057j.mo9772b());
        this.f10360a.f10359a.m9992i();
        this.f10360a.f10359a.m9732c();
    }
}
