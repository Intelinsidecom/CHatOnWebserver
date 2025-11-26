package com.sec.vip.amschaton.fragment;

import android.content.res.Resources;
import com.sec.vip.amschaton.C3424az;
import com.sec.vip.amschaton.InterfaceC3434bi;

/* compiled from: AMSComposerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.ao */
/* loaded from: classes.dex */
class C3467ao implements InterfaceC3434bi {

    /* renamed from: a */
    final /* synthetic */ C3424az f12828a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerFragment f12829b;

    C3467ao(AMSComposerFragment aMSComposerFragment, C3424az c3424az) {
        this.f12829b = aMSComposerFragment;
        this.f12828a = c3424az;
    }

    @Override // com.sec.vip.amschaton.InterfaceC3434bi
    /* renamed from: a */
    public boolean mo12234a() {
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC3434bi
    /* renamed from: b */
    public boolean mo12235b() throws Resources.NotFoundException {
        this.f12829b.f12662J = this.f12828a.m12262a();
        this.f12829b.f12661I = this.f12828a.m12264b();
        this.f12829b.m12426a(this.f12829b.f12662J, this.f12829b.f12661I);
        return true;
    }
}
