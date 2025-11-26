package com.sec.chaton.push.p040a;

import com.sec.chaton.push.p044c.AbstractC1099a;
import com.sec.chaton.push.p044c.InterfaceC1110d;
import com.sec.chaton.push.p044c.InterfaceC1117k;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.e */
/* loaded from: classes.dex */
class C1075e implements InterfaceC1117k {

    /* renamed from: a */
    final /* synthetic */ int f3997a;

    /* renamed from: b */
    final /* synthetic */ C1072b f3998b;

    C1075e(C1072b c1072b, int i) {
        this.f3998b = c1072b;
        this.f3997a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.chaton.push.p044c.InterfaceC1117k
    /* renamed from: a */
    public void mo4133a(AbstractC1099a abstractC1099a) {
        if (abstractC1099a != 0 && (abstractC1099a instanceof InterfaceC1110d)) {
            ((InterfaceC1110d) abstractC1099a).mo4151a(this.f3997a, null);
        }
    }
}
