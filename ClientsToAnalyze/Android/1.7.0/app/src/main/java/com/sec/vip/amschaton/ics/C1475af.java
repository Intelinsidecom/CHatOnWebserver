package com.sec.vip.amschaton.ics;

import android.content.res.Resources;
import com.sec.vip.amschaton.C1395be;
import com.sec.vip.amschaton.InterfaceC1397bg;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.af */
/* loaded from: classes.dex */
class C1475af implements InterfaceC1397bg {

    /* renamed from: a */
    final /* synthetic */ C1395be f5285a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f5286b;

    C1475af(AMSComposerActivity aMSComposerActivity, C1395be c1395be) {
        this.f5286b = aMSComposerActivity;
        this.f5285a = c1395be;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: a */
    public boolean mo4926a() {
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: b */
    public boolean mo4927b() throws Resources.NotFoundException {
        this.f5286b.f5188I = this.f5285a.m5001e();
        this.f5286b.f5187H = this.f5285a.m5002f();
        this.f5286b.m5346a(this.f5286b.f5188I, this.f5286b.f5187H);
        return true;
    }
}
