package com.sec.chaton.sns.p115ui.renren;

import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.sns.p114b.InterfaceC4378ad;

/* compiled from: RenrenSubMenuFragment.java */
/* renamed from: com.sec.chaton.sns.ui.renren.d */
/* loaded from: classes.dex */
class C4509d implements InterfaceC4378ad {

    /* renamed from: a */
    final /* synthetic */ RenrenSubMenuFragment f16243a;

    C4509d(RenrenSubMenuFragment renrenSubMenuFragment) {
        this.f16243a = renrenSubMenuFragment;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4378ad
    /* renamed from: a */
    public void mo16621a() {
        Toast.makeText(this.f16243a.f16236h, this.f16243a.f16236h.getString(R.string.facebook_post_completed), 0).show();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4378ad
    /* renamed from: b */
    public void mo16623b() {
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4378ad
    /* renamed from: a */
    public void mo16622a(int i) {
        Toast.makeText(this.f16243a.f16236h, this.f16243a.f16236h.getString(R.string.facebook_post_failed), 0).show();
    }
}
