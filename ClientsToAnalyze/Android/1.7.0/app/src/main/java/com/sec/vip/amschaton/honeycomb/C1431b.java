package com.sec.vip.amschaton.honeycomb;

import android.content.res.Resources;
import com.sec.vip.amschaton.InterfaceC1397bg;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.b */
/* loaded from: classes.dex */
class C1431b implements InterfaceC1397bg {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5064a;

    C1431b(AMSComposerActivity aMSComposerActivity) {
        this.f5064a = aMSComposerActivity;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: a */
    public boolean mo4926a() {
        this.f5064a.m5071e(false);
        this.f5064a.f4948M.m4963c();
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: b */
    public boolean mo4927b() throws Resources.NotFoundException {
        if (this.f5064a.f4948M.m4962b().getText().toString().length() > 0) {
            this.f5064a.f4936A.m4781a(this.f5064a.f4948M.m4958a(), this.f5064a.f4942G, this.f5064a.f4943H);
        }
        this.f5064a.m5071e(false);
        this.f5064a.f4948M.m4963c();
        return true;
    }
}
