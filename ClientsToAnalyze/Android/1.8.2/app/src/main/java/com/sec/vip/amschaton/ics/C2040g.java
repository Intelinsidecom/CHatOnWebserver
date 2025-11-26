package com.sec.vip.amschaton.ics;

import android.content.res.Resources;
import com.sec.vip.amschaton.C1851ak;
import com.sec.vip.amschaton.InterfaceC1872be;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.g */
/* loaded from: classes.dex */
class C2040g implements InterfaceC1872be {

    /* renamed from: a */
    final /* synthetic */ C1851ak f7331a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f7332b;

    C2040g(AMSComposerActivity aMSComposerActivity, C1851ak c1851ak) {
        this.f7332b = aMSComposerActivity;
        this.f7331a = c1851ak;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: e_ */
    public boolean mo6437e_() {
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: d_ */
    public boolean mo6436d_() throws Resources.NotFoundException {
        this.f7332b.f7156Q = this.f7331a.m6432c();
        this.f7332b.m6896a(this.f7332b.f7157R, this.f7332b.f7156Q);
        return true;
    }
}
