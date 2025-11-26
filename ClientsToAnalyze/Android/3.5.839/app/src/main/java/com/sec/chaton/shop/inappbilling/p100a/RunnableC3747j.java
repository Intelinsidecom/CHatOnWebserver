package com.sec.chaton.shop.inappbilling.p100a;

import java.util.List;

/* compiled from: IabHelper.java */
/* renamed from: com.sec.chaton.shop.inappbilling.a.j */
/* loaded from: classes.dex */
class RunnableC3747j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f13471a;

    /* renamed from: b */
    final /* synthetic */ RunnableC3745h f13472b;

    RunnableC3747j(RunnableC3745h runnableC3745h, List list) {
        this.f13472b = runnableC3745h;
        this.f13471a = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13472b.f13467d.m14126a(this.f13472b.f13464a, this.f13471a);
    }
}
