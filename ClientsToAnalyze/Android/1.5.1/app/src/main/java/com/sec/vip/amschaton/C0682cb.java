package com.sec.vip.amschaton;

/* renamed from: com.sec.vip.amschaton.cb */
/* loaded from: classes.dex */
class C0682cb implements OnApplyListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4303a;

    C0682cb(AMSComposerActivity aMSComposerActivity) {
        this.f4303a = aMSComposerActivity;
    }

    @Override // com.sec.vip.amschaton.OnApplyListener
    /* renamed from: a */
    public boolean mo4160a() {
        if (this.f4303a.f3831G.m3850h() != null) {
            return true;
        }
        this.f4303a.f3831G.m3833a(4, this.f4303a.f3840P, this.f4303a.f3841Q, this.f4303a.f3842R);
        this.f4303a.f3863n.setImageBitmap(this.f4303a.m3743a(4, this.f4303a.f3840P, this.f4303a.f3841Q, this.f4303a.f3842R));
        this.f4303a.f3831G.invalidate();
        return true;
    }

    @Override // com.sec.vip.amschaton.OnApplyListener
    /* renamed from: b */
    public boolean mo4161b() {
        this.f4303a.f3840P = this.f4303a.f3849Y.m3890a();
        this.f4303a.f3841Q = this.f4303a.f3849Y.m3892b();
        this.f4303a.f3842R = this.f4303a.f3849Y.m3894c();
        if (this.f4303a.f3831G.m3850h() == null) {
            this.f4303a.f3831G.m3833a(4, this.f4303a.f3840P, this.f4303a.f3841Q, this.f4303a.f3842R);
        } else {
            this.f4303a.f3831G.m3832a(this.f4303a.f3840P, this.f4303a.f3841Q, this.f4303a.f3842R);
        }
        this.f4303a.f3863n.setImageBitmap(this.f4303a.m3743a(4, this.f4303a.f3840P, this.f4303a.f3841Q, this.f4303a.f3842R));
        this.f4303a.f3831G.invalidate();
        this.f4303a.m3740J();
        return true;
    }
}
