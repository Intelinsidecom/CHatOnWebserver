package com.sec.vip.amschaton;

/* renamed from: com.sec.vip.amschaton.cn */
/* loaded from: classes.dex */
class C0694cn implements OnApplyListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4316a;

    C0694cn(AMSComposerActivity aMSComposerActivity) {
        this.f4316a = aMSComposerActivity;
    }

    @Override // com.sec.vip.amschaton.OnApplyListener
    /* renamed from: a */
    public boolean mo4160a() {
        this.f4316a.f3831G.m3833a(1, 4, this.f4316a.f3835K[this.f4316a.f3834J], this.f4316a.f3836L[4]);
        return true;
    }

    @Override // com.sec.vip.amschaton.OnApplyListener
    /* renamed from: b */
    public boolean mo4161b() {
        this.f4316a.f3836L[4] = this.f4316a.f3851aa.m3871a();
        this.f4316a.f3831G.m3833a(1, 4, this.f4316a.f3835K[this.f4316a.f3834J], this.f4316a.f3836L[4]);
        this.f4316a.getSharedPreferences("AMSPref", 3).edit().putInt("AMS_PEN_ERASER_SIZE", this.f4316a.f3836L[4]).commit();
        return true;
    }
}
