package com.sec.vip.amschaton.ics;

import android.content.res.Resources;
import com.sec.vip.amschaton.InterfaceC1872be;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.o */
/* loaded from: classes.dex */
class C2048o implements InterfaceC1872be {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7342a;

    C2048o(AMSComposerActivity aMSComposerActivity) {
        this.f7342a = aMSComposerActivity;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: e_ */
    public boolean mo6437e_() {
        this.f7342a.m6936f(false);
        this.f7342a.f7163X.m6496c();
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: d_ */
    public boolean mo6436d_() throws Resources.NotFoundException {
        if (this.f7342a.f7163X.m6495b().getText().toString().length() > 0) {
            this.f7342a.f7148I.m6302a(this.f7342a.f7163X.m6491a(), this.f7342a.f7156Q, this.f7342a.f7157R);
        }
        this.f7342a.m6936f(false);
        this.f7342a.f7163X.m6496c();
        return true;
    }
}
