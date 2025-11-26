package com.sec.vip.amschaton.honeycomb;

import android.content.res.Resources;
import com.sec.vip.amschaton.C1851ak;
import com.sec.vip.amschaton.InterfaceC1872be;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.v */
/* loaded from: classes.dex */
class C1971v implements InterfaceC1872be {

    /* renamed from: a */
    final /* synthetic */ C1851ak f7119a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f7120b;

    C1971v(AMSComposerActivity aMSComposerActivity, C1851ak c1851ak) {
        this.f7120b = aMSComposerActivity;
        this.f7119a = c1851ak;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: e_ */
    public boolean mo6437e_() {
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: d_ */
    public boolean mo6436d_() throws Resources.NotFoundException {
        this.f7120b.f6917F = this.f7119a.m6428a();
        if (this.f7120b.f6917F == this.f7120b.f6918G) {
            this.f7120b.f6920I[this.f7120b.f6917F] = this.f7119a.m6430b();
            this.f7120b.f6919H[this.f7120b.f6917F] = this.f7119a.m6432c();
        } else {
            this.f7119a.m6431b(this.f7120b.f6920I[this.f7120b.f6917F]);
            this.f7119a.m6433c(this.f7120b.f6919H[this.f7120b.f6917F]);
        }
        this.f7120b.m6569a(this.f7120b.f6917F, this.f7120b.f6920I[this.f7120b.f6917F], this.f7120b.f6919H[this.f7120b.f6917F]);
        this.f7120b.f6918G = this.f7120b.f6917F;
        return true;
    }
}
