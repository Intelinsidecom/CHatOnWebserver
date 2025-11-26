package com.sec.chaton.sns.p115ui.renren;

import com.sec.chaton.sns.p114b.InterfaceC4376ab;

/* compiled from: RenrenSubMenuFragment.java */
/* renamed from: com.sec.chaton.sns.ui.renren.b */
/* loaded from: classes.dex */
class C4507b implements InterfaceC4376ab {

    /* renamed from: a */
    final /* synthetic */ RenrenSubMenuFragment f16241a;

    C4507b(RenrenSubMenuFragment renrenSubMenuFragment) {
        this.f16241a = renrenSubMenuFragment;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9435a(int i) {
        this.f16241a.m16918e();
        this.f16241a.m16921h();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9434a() {
        this.f16241a.f16236h.runOnUiThread(new RunnableC4508c(this));
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: b */
    public void mo9436b() {
        this.f16241a.m16920g();
        if (this.f16241a.f16236h != null) {
            this.f16241a.f16236h.finish();
        }
    }
}
