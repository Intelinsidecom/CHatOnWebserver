package com.sec.chaton.settings.tellfriends;

import android.content.res.Resources;
import com.sec.chaton.R;
import com.sec.widget.C3641ai;

/* compiled from: WeiboMessageFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cb */
/* loaded from: classes.dex */
class C2779cb implements InterfaceC2731ah {

    /* renamed from: a */
    final /* synthetic */ WeiboMessageFragment f10211a;

    C2779cb(WeiboMessageFragment weiboMessageFragment) {
        this.f10211a = weiboMessageFragment;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2731ah
    /* renamed from: a */
    public void mo9780a(int i) throws Resources.NotFoundException {
        this.f10211a.m9975d();
        C3641ai.m13211a(this.f10211a.f10235a, this.f10211a.getResources().getString(R.string.facebook_post_failed), 0).show();
        this.f10211a.f10235a.finish();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2731ah
    /* renamed from: a */
    public void mo9779a() throws Resources.NotFoundException {
        this.f10211a.m9975d();
        C3641ai.m13211a(this.f10211a.f10235a, this.f10211a.getResources().getString(R.string.facebook_post_completed), 0).show();
        this.f10211a.f10235a.finish();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2731ah
    /* renamed from: b */
    public void mo9781b() {
        this.f10211a.m9975d();
        this.f10211a.f10235a.finish();
    }
}
