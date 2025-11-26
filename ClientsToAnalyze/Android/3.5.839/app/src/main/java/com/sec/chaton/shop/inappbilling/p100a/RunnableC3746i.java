package com.sec.chaton.shop.inappbilling.p100a;

import java.util.List;

/* compiled from: IabHelper.java */
/* renamed from: com.sec.chaton.shop.inappbilling.a.i */
/* loaded from: classes.dex */
class RunnableC3746i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f13469a;

    /* renamed from: b */
    final /* synthetic */ RunnableC3745h f13470b;

    RunnableC3746i(RunnableC3745h runnableC3745h, List list) {
        this.f13470b = runnableC3745h;
        this.f13469a = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13470b.f13465b.mo14125a((C3756s) this.f13470b.f13464a.get(0), (C3753p) this.f13469a.get(0));
    }
}
