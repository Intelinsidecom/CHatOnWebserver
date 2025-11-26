package com.sec.chaton.push.p050a;

import com.sec.chaton.push.p054c.AbstractC2072a;
import com.sec.chaton.push.p054c.InterfaceC2083d;
import com.sec.chaton.push.p054c.InterfaceC2090k;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.e */
/* loaded from: classes.dex */
class C2048e implements InterfaceC2090k {

    /* renamed from: a */
    final /* synthetic */ int f7900a;

    /* renamed from: b */
    final /* synthetic */ C2045b f7901b;

    C2048e(C2045b c2045b, int i) {
        this.f7901b = c2045b;
        this.f7900a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.chaton.push.p054c.InterfaceC2090k
    /* renamed from: a */
    public void mo8177a(AbstractC2072a abstractC2072a) {
        if (abstractC2072a != 0 && (abstractC2072a instanceof InterfaceC2083d)) {
            ((InterfaceC2083d) abstractC2072a).mo8195a(this.f7900a, null);
        }
    }
}
