package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.widget.C2153y;

/* compiled from: InviteFacebookActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.l */
/* loaded from: classes.dex */
class C1463l implements InterfaceC1371az {

    /* renamed from: a */
    final /* synthetic */ InviteFacebookActivity f5371a;

    C1463l(InviteFacebookActivity inviteFacebookActivity) {
        this.f5371a = inviteFacebookActivity;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1371az
    /* renamed from: a */
    public void mo5109a() {
        C1786r.m6061b("onComplete post to friend", getClass().getSimpleName());
        C2153y.m7536a(this.f5371a, this.f5371a.getString(R.string.tellfriends_facebook_invite_posted), 0).show();
        this.f5371a.m4815i();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1371az
    /* renamed from: b */
    public void mo5110b() {
        C1786r.m6061b("onCancelled post to friend", getClass().getSimpleName());
        this.f5371a.m4815i();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1371az
    /* renamed from: c */
    public void mo5111c() {
        C1786r.m6054a("onError post to friend", InviteFacebookActivity.f4944k);
        this.f5371a.m4810f();
        this.f5371a.m4797a(false);
    }
}
