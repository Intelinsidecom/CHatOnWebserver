package com.sec.chaton.sns.p115ui.facebook;

import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.sns.p114b.InterfaceC4378ad;

/* compiled from: FacebookSubMenuFragment.java */
/* renamed from: com.sec.chaton.sns.ui.facebook.c */
/* loaded from: classes.dex */
class C4484c implements InterfaceC4378ad {

    /* renamed from: a */
    final /* synthetic */ FacebookSubMenuFragment f16176a;

    C4484c(FacebookSubMenuFragment facebookSubMenuFragment) {
        this.f16176a = facebookSubMenuFragment;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4378ad
    /* renamed from: a */
    public void mo16621a() {
        Toast.makeText(this.f16176a.f16171i, this.f16176a.f16171i.getString(R.string.facebook_post_completed), 0).show();
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4378ad
    /* renamed from: b */
    public void mo16623b() {
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4378ad
    /* renamed from: a */
    public void mo16622a(int i) {
        Toast.makeText(this.f16176a.f16171i, this.f16176a.f16171i.getString(R.string.facebook_post_failed), 0).show();
    }
}
