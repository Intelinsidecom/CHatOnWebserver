package com.sec.chaton.push.p090a;

import com.sec.chaton.push.p094c.AbstractC3072a;
import com.sec.chaton.push.p094c.InterfaceC3083d;
import com.sec.chaton.push.p094c.InterfaceC3090k;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.e */
/* loaded from: classes.dex */
class C3048e implements InterfaceC3090k {

    /* renamed from: a */
    final /* synthetic */ int f11310a;

    /* renamed from: b */
    final /* synthetic */ C3045b f11311b;

    C3048e(C3045b c3045b, int i) {
        this.f11311b = c3045b;
        this.f11310a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.chaton.push.p094c.InterfaceC3090k
    /* renamed from: a */
    public void mo12520a(AbstractC3072a abstractC3072a) {
        if (abstractC3072a != 0 && (abstractC3072a instanceof InterfaceC3083d)) {
            ((InterfaceC3083d) abstractC3072a).mo12538a(this.f11310a, null);
        }
    }
}
