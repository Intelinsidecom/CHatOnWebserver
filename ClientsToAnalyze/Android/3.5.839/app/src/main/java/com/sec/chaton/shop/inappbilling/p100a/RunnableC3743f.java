package com.sec.chaton.shop.inappbilling.p100a;

import android.os.Handler;
import java.util.List;

/* compiled from: IabHelper.java */
/* renamed from: com.sec.chaton.shop.inappbilling.a.f */
/* loaded from: classes.dex */
class RunnableC3743f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f13456a;

    /* renamed from: b */
    final /* synthetic */ List f13457b;

    /* renamed from: c */
    final /* synthetic */ Handler f13458c;

    /* renamed from: d */
    final /* synthetic */ InterfaceC3752o f13459d;

    /* renamed from: e */
    final /* synthetic */ C3741d f13460e;

    RunnableC3743f(C3741d c3741d, boolean z, List list, Handler handler, InterfaceC3752o interfaceC3752o) {
        this.f13460e = c3741d;
        this.f13456a = z;
        this.f13457b = list;
        this.f13458c = handler;
        this.f13459d = interfaceC3752o;
    }

    @Override // java.lang.Runnable
    public void run() {
        C3753p c3753p = new C3753p(0, "Inventory refresh successful.");
        C3754q c3754qM14106a = null;
        try {
            c3754qM14106a = this.f13460e.m14106a(this.f13456a, this.f13457b);
        } catch (C3740c e) {
            c3753p = e.m14100a();
        }
        this.f13460e.m14120b();
        this.f13458c.post(new RunnableC3744g(this, c3753p, c3754qM14106a));
    }
}
