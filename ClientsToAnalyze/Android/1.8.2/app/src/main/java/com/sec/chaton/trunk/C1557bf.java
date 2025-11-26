package com.sec.chaton.trunk;

import com.sec.chaton.p015d.p016a.AbstractRunnableC0532a;
import com.sec.chaton.trunk.p048b.EnumC1551b;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.bf */
/* loaded from: classes.dex */
class C1557bf implements InterfaceC1605k {

    /* renamed from: a */
    final /* synthetic */ C1554bc f5634a;

    C1557bf(C1554bc c1554bc) {
        this.f5634a = c1554bc;
    }

    @Override // com.sec.chaton.trunk.InterfaceC1605k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractRunnableC0532a mo5428a(EnumC1551b enumC1551b, int i, int i2, String str) {
        if (this.f5634a.f5628m != null) {
            this.f5634a.f5628m.stopLoading();
        }
        if (this.f5634a.f5625j != null) {
            this.f5634a.f5625j.m2710c();
        }
        this.f5634a.f5625j = this.f5634a.f5624i.m5399a(false, this.f5634a.f5622g, i, enumC1551b, i2, str);
        return this.f5634a.f5625j;
    }
}
