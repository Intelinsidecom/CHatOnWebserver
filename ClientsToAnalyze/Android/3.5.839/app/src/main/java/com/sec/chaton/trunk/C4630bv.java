package com.sec.chaton.trunk;

import android.content.res.Resources;
import android.support.v4.view.InterfaceC0196cc;
import com.sec.chaton.util.C4904y;

/* compiled from: TrunkPageActivity.java */
/* renamed from: com.sec.chaton.trunk.bv */
/* loaded from: classes.dex */
class C4630bv implements InterfaceC0196cc {

    /* renamed from: a */
    final /* synthetic */ TrunkPageActivity f16807a;

    C4630bv(TrunkPageActivity trunkPageActivity) {
        this.f16807a = trunkPageActivity;
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: a */
    public void mo619a(int i) throws Resources.NotFoundException {
        C4904y.m18639b("onPageSelected : " + i, TrunkPageActivity.f16577s);
        this.f16807a.m17434a(i);
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: a */
    public void mo620a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.InterfaceC0196cc
    /* renamed from: b */
    public void mo622b(int i) {
    }
}
