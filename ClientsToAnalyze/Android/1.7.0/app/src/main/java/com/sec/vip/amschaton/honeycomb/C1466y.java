package com.sec.vip.amschaton.honeycomb;

import android.content.res.Resources;
import com.sec.vip.amschaton.C1395be;
import com.sec.vip.amschaton.InterfaceC1397bg;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.y */
/* loaded from: classes.dex */
class C1466y implements InterfaceC1397bg {

    /* renamed from: a */
    final /* synthetic */ C1395be f5116a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f5117b;

    C1466y(AMSComposerActivity aMSComposerActivity, C1395be c1395be) {
        this.f5117b = aMSComposerActivity;
        this.f5116a = c1395be;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: a */
    public boolean mo4926a() {
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: b */
    public boolean mo4927b() throws Resources.NotFoundException {
        this.f5117b.f4943H = this.f5116a.m5001e();
        this.f5117b.f4942G = this.f5116a.m5002f();
        this.f5117b.m5039a(this.f5117b.f4943H, this.f5117b.f4942G);
        return true;
    }
}
