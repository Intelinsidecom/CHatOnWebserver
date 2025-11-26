package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.util.C1786r;
import java.util.ArrayList;

/* compiled from: InviteFacebookActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.k */
/* loaded from: classes.dex */
class C1462k implements InterfaceC1368aw {

    /* renamed from: a */
    final /* synthetic */ InviteFacebookActivity f5370a;

    C1462k(InviteFacebookActivity inviteFacebookActivity) {
        this.f5370a = inviteFacebookActivity;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1368aw
    /* renamed from: a */
    public void mo5087a(ArrayList arrayList) {
        if (this.f5370a.f4959p) {
            this.f5370a.f4959p = false;
            return;
        }
        C1786r.m6061b("onComplete get friend list", getClass().getSimpleName());
        this.f5370a.f4957n = arrayList;
        this.f5370a.m4815i();
        if (this.f5370a.f4957n.size() == 0 || this.f5370a.f4957n == null) {
            this.f5370a.f4965v.setVisibility(0);
            return;
        }
        this.f5370a.f4960q = new C1468q(this.f5370a, this.f5370a, 0, this.f5370a.f4957n, null);
        this.f5370a.setListAdapter(this.f5370a.f4960q);
        this.f5370a.f4951g.setVisibility(0);
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1368aw
    /* renamed from: a */
    public void mo5086a() {
        C1786r.m6061b("onCancelled get friend list", getClass().getSimpleName());
        this.f5370a.m4815i();
        this.f5370a.finish();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC1368aw
    /* renamed from: b */
    public void mo5088b() {
        C1786r.m6054a("onError get friend list", InviteFacebookActivity.f4944k);
        this.f5370a.m4810f();
        this.f5370a.m4811g();
        this.f5370a.f4965v.setVisibility(0);
    }
}
