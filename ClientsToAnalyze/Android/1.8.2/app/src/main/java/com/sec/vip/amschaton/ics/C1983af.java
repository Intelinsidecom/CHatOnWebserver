package com.sec.vip.amschaton.ics;

import android.content.res.Resources;
import com.sec.vip.amschaton.C1851ak;
import com.sec.vip.amschaton.InterfaceC1872be;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.af */
/* loaded from: classes.dex */
class C1983af implements InterfaceC1872be {

    /* renamed from: a */
    final /* synthetic */ C1851ak f7253a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f7254b;

    C1983af(AMSComposerActivity aMSComposerActivity, C1851ak c1851ak) {
        this.f7254b = aMSComposerActivity;
        this.f7253a = c1851ak;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: e_ */
    public boolean mo6437e_() {
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: d_ */
    public boolean mo6436d_() throws Resources.NotFoundException {
        this.f7254b.f7154O = this.f7253a.m6430b();
        this.f7254b.m6897a(this.f7254b.f7153N, this.f7254b.f7154O, this.f7254b.f7155P);
        this.f7254b.f7193z.setText("" + this.f7254b.f7154O + "px");
        return true;
    }
}
