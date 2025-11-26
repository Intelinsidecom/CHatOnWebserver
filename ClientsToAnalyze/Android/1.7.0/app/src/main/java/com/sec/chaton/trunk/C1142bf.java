package com.sec.chaton.trunk;

import com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb;
import com.sec.chaton.trunk.p043c.EnumC1152a;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.bf */
/* loaded from: classes.dex */
class C1142bf implements InterfaceC1193s {

    /* renamed from: a */
    final /* synthetic */ C1105ac f3972a;

    C1142bf(C1105ac c1105ac) {
        this.f3972a = c1105ac;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1193s
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractRunnableC0153bb mo4172a(boolean z, EnumC1152a enumC1152a, int i, int i2) {
        if (this.f3972a.f3895m != null) {
            this.f3972a.f3895m.stopLoading();
        }
        if (this.f3972a.f3892j != null) {
            this.f3972a.f3892j.m686d();
        }
        if (enumC1152a != this.f3972a.f3888f) {
            this.f3972a.f3890h = true;
        }
        this.f3972a.f3892j = this.f3972a.f3891i.m4195a(z, this.f3972a.f3889g, i, enumC1152a, i2);
        return this.f3972a.f3892j;
    }
}
