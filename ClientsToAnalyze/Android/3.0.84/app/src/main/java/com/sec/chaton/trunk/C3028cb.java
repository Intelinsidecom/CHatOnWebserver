package com.sec.chaton.trunk;

import com.sec.chaton.p025d.p026a.AbstractC1145a;
import com.sec.chaton.trunk.p058a.EnumC2959b;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.cb */
/* loaded from: classes.dex */
class C3028cb implements InterfaceC3062p {

    /* renamed from: a */
    final /* synthetic */ C3018bz f10909a;

    C3028cb(C3018bz c3018bz) {
        this.f10909a = c3018bz;
    }

    @Override // com.sec.chaton.trunk.InterfaceC3062p
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC1145a mo10541a(boolean z, EnumC2959b enumC2959b, int i, int i2) {
        if (this.f10909a.f10891n != null) {
            this.f10909a.f10891n.stopLoading();
        }
        if (this.f10909a.f10887j != null) {
            this.f10909a.f10887j.m5493c();
        }
        if (enumC2959b != this.f10909a.f10883f) {
            this.f10909a.f10885h = true;
        }
        this.f10909a.f10887j = this.f10909a.f10886i.m10423a(z, this.f10909a.f10884g, i, enumC2959b, i2);
        return this.f10909a.f10887j;
    }
}
