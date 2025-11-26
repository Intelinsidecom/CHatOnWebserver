package com.sec.chaton.sns.p115ui.odnoklassniki;

import com.sec.chaton.sns.p114b.InterfaceC4376ab;
import com.sec.chaton.util.C4904y;
import java.security.NoSuchAlgorithmException;

/* compiled from: OdnokSubMenuFragment.java */
/* renamed from: com.sec.chaton.sns.ui.odnoklassniki.b */
/* loaded from: classes.dex */
class C4502b implements InterfaceC4376ab {

    /* renamed from: a */
    final /* synthetic */ OdnokSubMenuFragment f16221a;

    C4502b(OdnokSubMenuFragment odnokSubMenuFragment) {
        this.f16221a = odnokSubMenuFragment;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9435a(int i) {
        this.f16221a.m16918e();
        this.f16221a.m16921h();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9434a() throws NoSuchAlgorithmException {
        C4904y.m18639b("onComplete() \t- Login", OdnokSubMenuFragment.f16202g);
        this.f16221a.m16913a(this.f16221a.f16205j.mo16647b());
        this.f16221a.m16920g();
        this.f16221a.m17020j();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: b */
    public void mo9436b() {
        this.f16221a.m16920g();
        if (this.f16221a.f16204i != null) {
            this.f16221a.f16204i.finish();
        }
    }
}
