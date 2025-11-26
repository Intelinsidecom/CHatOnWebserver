package com.sec.vip.amschaton.ics;

import android.content.res.Resources;
import com.sec.vip.amschaton.C1851ak;
import com.sec.vip.amschaton.InterfaceC1872be;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ae */
/* loaded from: classes.dex */
class C1982ae implements InterfaceC1872be {

    /* renamed from: a */
    final /* synthetic */ C1851ak f7251a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f7252b;

    C1982ae(AMSComposerActivity aMSComposerActivity, C1851ak c1851ak) {
        this.f7252b = aMSComposerActivity;
        this.f7251a = c1851ak;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: e_ */
    public boolean mo6437e_() {
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: d_ */
    public boolean mo6436d_() throws Resources.NotFoundException {
        this.f7252b.f7153N = this.f7251a.m6428a();
        this.f7252b.m6897a(this.f7252b.f7153N, this.f7252b.f7154O, this.f7252b.f7155P);
        this.f7252b.m6921c(true);
        return true;
    }
}
