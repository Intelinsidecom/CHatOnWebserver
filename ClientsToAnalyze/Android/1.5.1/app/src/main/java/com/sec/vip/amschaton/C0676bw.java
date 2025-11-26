package com.sec.vip.amschaton;

/* renamed from: com.sec.vip.amschaton.bw */
/* loaded from: classes.dex */
class C0676bw implements OnApplyListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4297a;

    C0676bw(AMSComposerActivity aMSComposerActivity) {
        this.f4297a = aMSComposerActivity;
    }

    @Override // com.sec.vip.amschaton.OnApplyListener
    /* renamed from: a */
    public boolean mo4160a() {
        if (this.f4297a.f3831G.m3850h() != null) {
            return true;
        }
        this.f4297a.f3831G.m3833a(2, 0, this.f4297a.f3837M, this.f4297a.f3838N);
        this.f4297a.f3831G.invalidate();
        return true;
    }

    @Override // com.sec.vip.amschaton.OnApplyListener
    /* renamed from: b */
    public boolean mo4161b() {
        this.f4297a.f3837M = this.f4297a.f3848X.m4104a();
        this.f4297a.f3838N = this.f4297a.f3848X.m4106b();
        if (this.f4297a.f3831G.m3850h() == null) {
            this.f4297a.f3831G.m3833a(2, 0, this.f4297a.f3837M, this.f4297a.f3838N);
        } else {
            this.f4297a.f3831G.m3832a(0, this.f4297a.f3837M, this.f4297a.f3838N);
        }
        this.f4297a.f3831G.invalidate();
        this.f4297a.m3740J();
        return true;
    }
}
