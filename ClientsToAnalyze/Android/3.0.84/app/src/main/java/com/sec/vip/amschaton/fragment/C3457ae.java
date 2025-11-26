package com.sec.vip.amschaton.fragment;

import android.content.res.Resources;
import com.sec.vip.amschaton.InterfaceC3434bi;

/* compiled from: AMSComposerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.ae */
/* loaded from: classes.dex */
class C3457ae implements InterfaceC3434bi {

    /* renamed from: a */
    final /* synthetic */ AMSComposerFragment f12817a;

    C3457ae(AMSComposerFragment aMSComposerFragment) {
        this.f12817a = aMSComposerFragment;
    }

    @Override // com.sec.vip.amschaton.InterfaceC3434bi
    /* renamed from: a */
    public boolean mo12234a() {
        this.f12817a.m12462e(false);
        if (this.f12817a.f12667O != null) {
            this.f12817a.f12667O.m12318c();
            return true;
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC3434bi
    /* renamed from: b */
    public boolean mo12235b() throws Resources.NotFoundException {
        if (this.f12817a.f12667O.m12317b().getText().toString().length() > 0) {
            this.f12817a.f12654B.m12013a(this.f12817a.f12667O.m12313a(), this.f12817a.f12661I, this.f12817a.f12662J);
        }
        this.f12817a.m12462e(false);
        this.f12817a.f12667O.m12318c();
        return true;
    }
}
