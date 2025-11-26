package com.sec.vip.amschaton.honeycomb;

import android.content.res.Resources;
import com.sec.vip.amschaton.C1369af;
import com.sec.vip.amschaton.InterfaceC1397bg;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.z */
/* loaded from: classes.dex */
class C1467z implements InterfaceC1397bg {

    /* renamed from: a */
    final /* synthetic */ C1369af f5118a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f5119b;

    C1467z(AMSComposerActivity aMSComposerActivity, C1369af c1369af) {
        this.f5119b = aMSComposerActivity;
        this.f5118a = c1369af;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: a */
    public boolean mo4926a() {
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: b */
    public boolean mo4927b() throws Resources.NotFoundException {
        this.f5119b.f4939D = this.f5118a.m4922e();
        this.f5119b.f4940E = this.f5118a.m4923f();
        this.f5119b.f4941F = this.f5118a.m4924g();
        this.f5119b.m5040a(this.f5119b.f4939D, this.f5119b.f4940E, this.f5119b.f4941F);
        return true;
    }
}
