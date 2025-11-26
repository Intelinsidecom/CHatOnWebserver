package com.sec.chaton.trunk;

import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.trunk.p048b.EnumC1551b;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.be */
/* loaded from: classes.dex */
class C1556be implements InterfaceC1606l {

    /* renamed from: a */
    final /* synthetic */ C1554bc f5633a;

    C1556be(C1554bc c1554bc) {
        this.f5633a = c1554bc;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1606l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractRunnableC0532a mo5426a(boolean z, EnumC1551b enumC1551b, int i, int i2) {
        if (this.f5633a.f5628m != null) {
            this.f5633a.f5628m.stopLoading();
        }
        if (this.f5633a.f5625j != null) {
            this.f5633a.f5625j.m2710c();
        }
        if (enumC1551b != this.f5633a.f5621f) {
            this.f5633a.f5623h = true;
        }
        this.f5633a.f5625j = this.f5633a.f5624i.m5398a(z, this.f5633a.f5622g, i, enumC1551b, i2);
        return this.f5633a.f5625j;
    }
}
