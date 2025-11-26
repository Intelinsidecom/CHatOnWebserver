package com.sec.chaton.settings.tellfriends;

import android.content.res.Resources;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: FacebookMessageFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.b */
/* loaded from: classes.dex */
class C2750b implements InterfaceC2731ah {

    /* renamed from: a */
    final /* synthetic */ FacebookMessageFragment f10147a;

    C2750b(FacebookMessageFragment facebookMessageFragment) {
        this.f10147a = facebookMessageFragment;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2731ah
    /* renamed from: a */
    public void mo9780a(int i) throws Resources.NotFoundException {
        this.f10147a.m9975d();
        C3641ai.m13211a(this.f10147a.f10235a, this.f10147a.getResources().getString(R.string.facebook_post_failed), 0).show();
        this.f10147a.f10235a.finish();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2731ah
    /* renamed from: a */
    public void mo9779a() throws Resources.NotFoundException {
        this.f10147a.m9975d();
        C3641ai.m13211a(this.f10147a.f10235a, this.f10147a.getResources().getString(R.string.facebook_post_completed), 0).show();
        this.f10147a.f10235a.finish();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2731ah
    /* renamed from: b */
    public void mo9781b() {
        this.f10147a.m9975d();
        this.f10147a.f10235a.finish();
    }
}
