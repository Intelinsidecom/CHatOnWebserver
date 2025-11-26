package com.sec.chaton.shop.inappbilling.p100a;

import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IabHelper.java */
/* renamed from: com.sec.chaton.shop.inappbilling.a.h */
/* loaded from: classes.dex */
class RunnableC3745h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f13464a;

    /* renamed from: b */
    final /* synthetic */ InterfaceC3748k f13465b;

    /* renamed from: c */
    final /* synthetic */ Handler f13466c;

    /* renamed from: d */
    final /* synthetic */ InterfaceC3749l f13467d;

    /* renamed from: e */
    final /* synthetic */ C3741d f13468e;

    RunnableC3745h(C3741d c3741d, List list, InterfaceC3748k interfaceC3748k, Handler handler, InterfaceC3749l interfaceC3749l) {
        this.f13468e = c3741d;
        this.f13464a = list;
        this.f13465b = interfaceC3748k;
        this.f13466c = handler;
        this.f13467d = interfaceC3749l;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList = new ArrayList();
        for (C3756s c3756s : this.f13464a) {
            try {
                this.f13468e.m14113a(c3756s);
                arrayList.add(new C3753p(0, "Successful consume of sku " + c3756s.m14138b()));
            } catch (C3740c e) {
                arrayList.add(e.m14100a());
            }
        }
        this.f13468e.m14120b();
        if (this.f13465b != null) {
            this.f13466c.post(new RunnableC3746i(this, arrayList));
        }
        if (this.f13467d != null) {
            this.f13466c.post(new RunnableC3747j(this, arrayList));
        }
    }
}
