package com.facebook.p008b;

import com.facebook.C0107ba;
import com.facebook.EnumC0125bs;
import com.facebook.InterfaceC0120bn;

/* compiled from: SessionTracker.java */
/* renamed from: com.facebook.b.r */
/* loaded from: classes.dex */
class C0104r implements InterfaceC0120bn {

    /* renamed from: a */
    final /* synthetic */ C0101o f195a;

    /* renamed from: b */
    private final InterfaceC0120bn f196b;

    public C0104r(C0101o c0101o, InterfaceC0120bn interfaceC0120bn) {
        this.f195a = c0101o;
        this.f196b = interfaceC0120bn;
    }

    @Override // com.facebook.InterfaceC0120bn
    /* renamed from: a */
    public void mo263a(C0107ba c0107ba, EnumC0125bs enumC0125bs, Exception exc) {
        if (this.f196b != null && this.f195a.m262d()) {
            this.f196b.mo263a(c0107ba, enumC0125bs, exc);
        }
        if (c0107ba == this.f195a.f189a && enumC0125bs.m363b()) {
            this.f195a.m259a((C0107ba) null);
        }
    }
}
