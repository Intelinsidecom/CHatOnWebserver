package com.sec.vip.amschaton.honeycomb;

import android.content.res.Resources;
import com.sec.vip.amschaton.C1862av;
import com.sec.vip.amschaton.InterfaceC1872be;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.w */
/* loaded from: classes.dex */
class C1972w implements InterfaceC1872be {

    /* renamed from: a */
    final /* synthetic */ C1862av f7121a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f7122b;

    C1972w(AMSComposerActivity aMSComposerActivity, C1862av c1862av) {
        this.f7122b = aMSComposerActivity;
        this.f7121a = c1862av;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: e_ */
    public boolean mo6437e_() {
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: d_ */
    public boolean mo6436d_() throws Resources.NotFoundException {
        this.f7122b.f6922K = this.f7121a.m6461a();
        this.f7122b.f6921J = this.f7121a.m6463b();
        this.f7122b.m6568a(this.f7122b.f6922K, this.f7122b.f6921J);
        return true;
    }
}
