package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.widget.C2153y;

/* compiled from: FacebookMessageActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.c */
/* loaded from: classes.dex */
class C1399c implements InterfaceC1371az {

    /* renamed from: a */
    final /* synthetic */ FacebookMessageActivity f5262a;

    C1399c(FacebookMessageActivity facebookMessageActivity) {
        this.f5262a = facebookMessageActivity;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1371az
    /* renamed from: a */
    public void mo5109a() {
        C1786r.m6061b("onComplete post to friend", this.f5262a.f4923e);
        C2153y.m7536a(this.f5262a.f4925g, this.f5262a.getString(R.string.facebook_post_completed), 0).show();
        this.f5262a.m4765c();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1371az
    /* renamed from: b */
    public void mo5110b() {
        C1786r.m6061b("onCancelled post to friend", getClass().getSimpleName());
        this.f5262a.m4765c();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1371az
    /* renamed from: c */
    public void mo5111c() {
        C1786r.m6054a("onError post to friend", this.f5262a.f4923e);
        this.f5262a.m4762b();
        this.f5262a.m4759a(false);
    }
}
