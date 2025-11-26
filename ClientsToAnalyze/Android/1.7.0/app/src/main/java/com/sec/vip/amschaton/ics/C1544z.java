package com.sec.vip.amschaton.ics;

import android.content.res.Resources;
import com.sec.vip.amschaton.C1369af;
import com.sec.vip.amschaton.InterfaceC1397bg;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.z */
/* loaded from: classes.dex */
class C1544z implements InterfaceC1397bg {

    /* renamed from: a */
    final /* synthetic */ C1369af f5374a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f5375b;

    C1544z(AMSComposerActivity aMSComposerActivity, C1369af c1369af) {
        this.f5375b = aMSComposerActivity;
        this.f5374a = c1369af;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: a */
    public boolean mo4926a() {
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: b */
    public boolean mo4927b() throws Resources.NotFoundException {
        this.f5375b.f5183D = this.f5374a.m4922e();
        if (this.f5375b.f5183D == this.f5375b.f5184E) {
            this.f5375b.f5186G[this.f5375b.f5183D] = this.f5374a.m4923f();
            this.f5375b.f5185F[this.f5375b.f5183D] = this.f5374a.m4924g();
        } else {
            this.f5374a.m4920b(this.f5375b.f5186G[this.f5375b.f5183D]);
            this.f5374a.m4921c(this.f5375b.f5185F[this.f5375b.f5183D]);
        }
        this.f5375b.m5347a(this.f5375b.f5183D, this.f5375b.f5186G[this.f5375b.f5183D], this.f5375b.f5185F[this.f5375b.f5183D]);
        this.f5375b.f5184E = this.f5375b.f5183D;
        return true;
    }
}
