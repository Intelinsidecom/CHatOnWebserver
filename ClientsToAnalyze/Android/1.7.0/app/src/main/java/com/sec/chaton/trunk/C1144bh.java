package com.sec.chaton.trunk;

import com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb;
import com.sec.chaton.trunk.p043c.EnumC1152a;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.bh */
/* loaded from: classes.dex */
class C1144bh implements InterfaceC1106ad {

    /* renamed from: a */
    final /* synthetic */ C1105ac f3974a;

    C1144bh(C1105ac c1105ac) {
        this.f3974a = c1105ac;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1106ad
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractRunnableC0153bb mo4141a(EnumC1152a enumC1152a, int i, int i2, String str) {
        if (this.f3974a.f3895m != null) {
            this.f3974a.f3895m.stopLoading();
        }
        if (this.f3974a.f3892j != null) {
            this.f3974a.f3892j.m686d();
        }
        this.f3974a.f3892j = this.f3974a.f3891i.m4196a(false, this.f3974a.f3889g, i, enumC1152a, i2, str);
        return this.f3974a.f3892j;
    }
}
