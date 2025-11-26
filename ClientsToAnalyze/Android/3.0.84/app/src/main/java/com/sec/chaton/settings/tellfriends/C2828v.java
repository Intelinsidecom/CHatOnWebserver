package com.sec.chaton.settings.tellfriends;

/* compiled from: RenrenSubMenuFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.v */
/* loaded from: classes.dex */
class C2828v implements InterfaceC2729af {

    /* renamed from: a */
    final /* synthetic */ RenrenSubMenuFragment f10359a;

    C2828v(RenrenSubMenuFragment renrenSubMenuFragment) {
        this.f10359a = renrenSubMenuFragment;
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onError(int i) {
        this.f10359a.m9990g();
        this.f10359a.m9993j();
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onComplete() {
        this.f10359a.f10055h.runOnUiThread(new RunnableC2829w(this));
    }

    @Override // com.sec.chaton.settings.tellfriends.InterfaceC2729af
    public void onCancelled() {
        this.f10359a.m9992i();
        if (this.f10359a.f10055h != null) {
            this.f10359a.f10055h.finish();
        }
    }
}
