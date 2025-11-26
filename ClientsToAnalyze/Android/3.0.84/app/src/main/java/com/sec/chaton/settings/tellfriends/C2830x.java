package com.sec.chaton.settings.tellfriends;

import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: RenrenSubMenuFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.x */
/* loaded from: classes.dex */
class C2830x implements InterfaceC2731ah {

    /* renamed from: a */
    final /* synthetic */ RenrenSubMenuFragment f10361a;

    C2830x(RenrenSubMenuFragment renrenSubMenuFragment) {
        this.f10361a = renrenSubMenuFragment;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2731ah
    /* renamed from: a */
    public void mo9779a() {
        Toast.makeText(this.f10361a.f10055h, this.f10361a.f10055h.getString(R.string.facebook_post_completed), 0).show();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2731ah
    /* renamed from: b */
    public void mo9781b() {
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2731ah
    /* renamed from: a */
    public void mo9780a(int i) {
        Toast.makeText(this.f10361a.f10055h, this.f10361a.f10055h.getString(R.string.facebook_post_failed), 0).show();
    }
}
