package com.facebook;

import java.util.Iterator;

/* compiled from: Session.java */
/* renamed from: com.facebook.bd */
/* loaded from: classes.dex */
class RunnableC0110bd implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC0125bs f216a;

    /* renamed from: b */
    final /* synthetic */ Exception f217b;

    /* renamed from: c */
    final /* synthetic */ C0107ba f218c;

    RunnableC0110bd(C0107ba c0107ba, EnumC0125bs enumC0125bs, Exception exc) {
        this.f218c = c0107ba;
        this.f216a = enumC0125bs;
        this.f217b = exc;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f218c.f209m.iterator();
        while (it.hasNext()) {
            C0107ba.m297b(this.f218c.f210n, new RunnableC0111be(this, (InterfaceC0120bn) it.next()));
        }
    }
}
