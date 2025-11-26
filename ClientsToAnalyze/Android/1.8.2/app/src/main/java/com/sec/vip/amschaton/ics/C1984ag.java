package com.sec.vip.amschaton.ics;

import android.content.res.Resources;
import com.sec.vip.amschaton.C1851ak;
import com.sec.vip.amschaton.InterfaceC1872be;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ag */
/* loaded from: classes.dex */
class C1984ag implements InterfaceC1872be {

    /* renamed from: a */
    final /* synthetic */ C1851ak f7255a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f7256b;

    C1984ag(AMSComposerActivity aMSComposerActivity, C1851ak c1851ak) {
        this.f7256b = aMSComposerActivity;
        this.f7255a = c1851ak;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: e_ */
    public boolean mo6437e_() {
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: d_ */
    public boolean mo6436d_() throws Resources.NotFoundException {
        this.f7256b.f7155P = this.f7255a.m6432c();
        this.f7256b.m6897a(this.f7256b.f7153N, this.f7256b.f7154O, this.f7256b.f7155P);
        this.f7256b.m6921c(true);
        return true;
    }
}
