package com.sec.vip.amschaton.honeycomb;

import android.content.res.Resources;
import com.sec.vip.amschaton.InterfaceC1872be;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.i */
/* loaded from: classes.dex */
class C1958i implements InterfaceC1872be {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7105a;

    C1958i(AMSComposerActivity aMSComposerActivity) {
        this.f7105a = aMSComposerActivity;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: e_ */
    public boolean mo6437e_() {
        this.f7105a.m6601e(false);
        this.f7105a.f6927P.m6496c();
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: d_ */
    public boolean mo6436d_() throws Resources.NotFoundException {
        if (this.f7105a.f6943af.getText().toString().length() > 0) {
            this.f7105a.f6914C.m6302a(this.f7105a.f6927P.m6491a(), this.f7105a.f6921J, this.f7105a.f6922K);
        }
        this.f7105a.m6601e(false);
        this.f7105a.f6927P.m6496c();
        return true;
    }
}
