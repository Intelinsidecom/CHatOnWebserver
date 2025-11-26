package com.sec.chaton.trunk;

import com.sec.chaton.p025d.p026a.AbstractC1145a;
import com.sec.chaton.trunk.p058a.EnumC2959b;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.cc */
/* loaded from: classes.dex */
class C3029cc implements InterfaceC3060n {

    /* renamed from: a */
    final /* synthetic */ C3018bz f10910a;

    C3029cc(C3018bz c3018bz) {
        this.f10910a = c3018bz;
    }

    @Override // com.sec.chaton.trunk.InterfaceC3060n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC1145a mo10543a(EnumC2959b enumC2959b, int i, int i2, String str) {
        if (this.f10910a.f10891n != null) {
            this.f10910a.f10891n.stopLoading();
        }
        if (this.f10910a.f10887j != null) {
            this.f10910a.f10887j.m5493c();
        }
        this.f10910a.f10887j = this.f10910a.f10886i.m10424a(false, this.f10910a.f10884g, i, enumC2959b, i2, str);
        return this.f10910a.f10887j;
    }
}
