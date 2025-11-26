package com.sec.vip.amschaton.ics;

import android.content.res.Resources;
import com.sec.vip.amschaton.C1851ak;
import com.sec.vip.amschaton.InterfaceC1872be;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ah */
/* loaded from: classes.dex */
class C1985ah implements InterfaceC1872be {

    /* renamed from: a */
    final /* synthetic */ C1851ak f7257a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f7258b;

    C1985ah(AMSComposerActivity aMSComposerActivity, C1851ak c1851ak) {
        this.f7258b = aMSComposerActivity;
        this.f7257a = c1851ak;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: e_ */
    public boolean mo6437e_() {
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: d_ */
    public boolean mo6436d_() throws Resources.NotFoundException {
        this.f7258b.f7157R = this.f7257a.m6430b();
        this.f7258b.m6896a(this.f7258b.f7157R, this.f7258b.f7156Q);
        return true;
    }
}
