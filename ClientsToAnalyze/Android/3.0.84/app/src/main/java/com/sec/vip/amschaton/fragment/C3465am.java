package com.sec.vip.amschaton.fragment;

import android.content.res.Resources;
import com.sec.vip.amschaton.C3412an;
import com.sec.vip.amschaton.InterfaceC3434bi;

/* compiled from: AMSComposerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.am */
/* loaded from: classes.dex */
class C3465am implements InterfaceC3434bi {

    /* renamed from: a */
    final /* synthetic */ C3412an f12825a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerFragment f12826b;

    C3465am(AMSComposerFragment aMSComposerFragment, C3412an c3412an) {
        this.f12826b = aMSComposerFragment;
        this.f12825a = c3412an;
    }

    @Override // com.sec.vip.amschaton.InterfaceC3434bi
    /* renamed from: a */
    public boolean mo12234a() {
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC3434bi
    /* renamed from: b */
    public boolean mo12235b() throws Resources.NotFoundException {
        this.f12826b.f12657E = this.f12825a.m12226a();
        if (this.f12826b.f12657E == this.f12826b.f12658F) {
            this.f12826b.f12660H[this.f12826b.f12657E] = this.f12825a.m12228b();
            this.f12826b.f12659G[this.f12826b.f12657E] = this.f12825a.m12230c();
        } else {
            this.f12825a.m12229b(this.f12826b.f12660H[this.f12826b.f12657E]);
            this.f12825a.m12231c(this.f12826b.f12659G[this.f12826b.f12657E]);
        }
        this.f12826b.m12427a(this.f12826b.f12657E, this.f12826b.f12660H[this.f12826b.f12657E], this.f12826b.f12659G[this.f12826b.f12657E]);
        this.f12826b.f12658F = this.f12826b.f12657E;
        return true;
    }
}
