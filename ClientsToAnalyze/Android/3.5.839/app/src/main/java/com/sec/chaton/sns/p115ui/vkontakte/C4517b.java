package com.sec.chaton.sns.p115ui.vkontakte;

import com.sec.chaton.sns.p114b.InterfaceC4376ab;
import com.sec.chaton.util.C4904y;

/* compiled from: VKontakteSubMenuFragment.java */
/* renamed from: com.sec.chaton.sns.ui.vkontakte.b */
/* loaded from: classes.dex */
class C4517b implements InterfaceC4376ab {

    /* renamed from: a */
    final /* synthetic */ VKontakteSubMenuFragment f16266a;

    C4517b(VKontakteSubMenuFragment vKontakteSubMenuFragment) {
        this.f16266a = vKontakteSubMenuFragment;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9435a(int i) {
        this.f16266a.m16918e();
        this.f16266a.m16921h();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9434a() {
        C4904y.m18639b("onComplete() \t- Login", VKontakteSubMenuFragment.f16261g);
        this.f16266a.m16913a(this.f16266a.f16264j.mo16647b());
        this.f16266a.m16920g();
        this.f16266a.m17100j();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: b */
    public void mo9436b() {
        this.f16266a.m16920g();
        if (this.f16266a.f16262h != null) {
            this.f16266a.f16262h.finish();
        }
    }
}
