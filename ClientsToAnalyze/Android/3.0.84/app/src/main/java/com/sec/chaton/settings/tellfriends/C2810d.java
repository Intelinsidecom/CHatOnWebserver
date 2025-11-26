package com.sec.chaton.settings.tellfriends;

import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: FacebookSubMenuFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.d */
/* loaded from: classes.dex */
class C2810d implements InterfaceC2731ah {

    /* renamed from: a */
    final /* synthetic */ FacebookSubMenuFragment f10323a;

    C2810d(FacebookSubMenuFragment facebookSubMenuFragment) {
        this.f10323a = facebookSubMenuFragment;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2731ah
    /* renamed from: a */
    public void mo9779a() {
        Toast.makeText(this.f10323a.f10049i, this.f10323a.f10049i.getString(R.string.facebook_post_completed), 0).show();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2731ah
    /* renamed from: b */
    public void mo9781b() {
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2731ah
    /* renamed from: a */
    public void mo9780a(int i) {
        Toast.makeText(this.f10323a.f10049i, this.f10323a.f10049i.getString(R.string.facebook_post_failed), 0).show();
    }
}
