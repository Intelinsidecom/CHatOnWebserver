package com.sec.chaton.sns.p115ui.renren;

import android.content.res.Resources;
import com.sec.chaton.R;
import com.sec.chaton.sns.p114b.InterfaceC4378ad;
import com.sec.widget.C5179v;

/* compiled from: RenrenMessageFragment.java */
/* renamed from: com.sec.chaton.sns.ui.renren.a */
/* loaded from: classes.dex */
class C4506a implements InterfaceC4378ad {

    /* renamed from: a */
    final /* synthetic */ RenrenMessageFragment f16240a;

    C4506a(RenrenMessageFragment renrenMessageFragment) {
        this.f16240a = renrenMessageFragment;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4378ad
    /* renamed from: a */
    public void mo16622a(int i) throws Resources.NotFoundException {
        this.f16240a.m16902d();
        C5179v.m19811a(this.f16240a.f16037a, this.f16240a.getResources().getString(R.string.facebook_post_failed), 0).show();
        this.f16240a.f16037a.finish();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4378ad
    /* renamed from: a */
    public void mo16621a() throws Resources.NotFoundException {
        this.f16240a.m16902d();
        C5179v.m19811a(this.f16240a.f16037a, this.f16240a.getResources().getString(R.string.facebook_post_completed), 0).show();
        this.f16240a.f16037a.finish();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4378ad
    /* renamed from: b */
    public void mo16623b() {
        this.f16240a.m16902d();
        this.f16240a.f16037a.finish();
    }
}
