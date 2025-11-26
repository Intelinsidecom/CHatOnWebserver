package com.facebook;

import java.util.Iterator;

/* compiled from: Session.java */
/* renamed from: com.facebook.bd */
/* loaded from: classes.dex */
class RunnableC0481bd implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC0496bs f1185a;

    /* renamed from: b */
    final /* synthetic */ Exception f1186b;

    /* renamed from: c */
    final /* synthetic */ C0478ba f1187c;

    RunnableC0481bd(C0478ba c0478ba, EnumC0496bs enumC0496bs, Exception exc) {
        this.f1187c = c0478ba;
        this.f1185a = enumC0496bs;
        this.f1186b = exc;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f1187c.f1178m.iterator();
        while (it.hasNext()) {
            C0478ba.m1741b(this.f1187c.f1179n, new RunnableC0482be(this, (InterfaceC0491bn) it.next()));
        }
    }
}
