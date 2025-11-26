package com.sec.chaton.p025d;

import com.sec.chaton.settings.tellfriends.InterfaceC2729af;

/* compiled from: SnsAccountControl.java */
/* renamed from: com.sec.chaton.d.av */
/* loaded from: classes.dex */
class C1309av implements InterfaceC2729af {

    /* renamed from: a */
    final /* synthetic */ C1308au f4956a;

    C1309av(C1308au c1308au) {
        this.f4956a = c1308au;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onError(int i) {
        this.f4956a.m5622a(1302);
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onComplete() {
        String strMo9772b = this.f4956a.f4948g.mo9772b();
        if (strMo9772b != null && !strMo9772b.isEmpty()) {
            this.f4956a.m5645l();
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onCancelled() {
        this.f4956a.m5622a(1303);
    }
}
