package com.facebook.p032b;

import com.facebook.C0478ba;
import com.facebook.EnumC0496bs;
import com.facebook.InterfaceC0491bn;

/* compiled from: SessionTracker.java */
/* renamed from: com.facebook.b.r */
/* loaded from: classes.dex */
class C0475r implements InterfaceC0491bn {

    /* renamed from: a */
    final /* synthetic */ C0472o f1164a;

    /* renamed from: b */
    private final InterfaceC0491bn f1165b;

    public C0475r(C0472o c0472o, InterfaceC0491bn interfaceC0491bn) {
        this.f1164a = c0472o;
        this.f1165b = interfaceC0491bn;
    }

    @Override // com.facebook.InterfaceC0491bn
    /* renamed from: a */
    public void mo1707a(C0478ba c0478ba, EnumC0496bs enumC0496bs, Exception exc) {
        if (this.f1165b != null && this.f1164a.m1706d()) {
            this.f1165b.mo1707a(c0478ba, enumC0496bs, exc);
        }
        if (c0478ba == this.f1164a.f1158a && enumC0496bs.m1806b()) {
            this.f1164a.m1703a((C0478ba) null);
        }
    }
}
