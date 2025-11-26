package com.sec.vip.amschaton;

/* compiled from: AMSBgColorSelectionDialog.java */
/* renamed from: com.sec.vip.amschaton.g */
/* loaded from: classes.dex */
class C3574g implements InterfaceC3434bi {

    /* renamed from: a */
    final /* synthetic */ DialogInterfaceOnClickListenerC3449d f13027a;

    C3574g(DialogInterfaceOnClickListenerC3449d dialogInterfaceOnClickListenerC3449d) {
        this.f13027a = dialogInterfaceOnClickListenerC3449d;
    }

    @Override // com.sec.vip.amschaton.InterfaceC3434bi
    /* renamed from: a */
    public boolean mo12234a() {
        this.f13027a.f12613a.m12775e();
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC3434bi
    /* renamed from: b */
    public boolean mo12235b() {
        this.f13027a.m12341a(this.f13027a.m12345c(this.f13027a.f12617e), false);
        this.f13027a.m12351a(this.f13027a.f12613a.m12772b());
        if (this.f13027a.f12622j != null) {
            this.f13027a.f12622j.mo12235b();
        }
        if (this.f13027a.f12613a != null) {
            this.f13027a.f12613a.m12775e();
        }
        this.f13027a.f12616d.dismiss();
        return true;
    }
}
