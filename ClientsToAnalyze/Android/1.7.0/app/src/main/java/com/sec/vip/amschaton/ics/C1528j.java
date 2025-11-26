package com.sec.vip.amschaton.ics;

import android.content.res.Resources;
import com.sec.vip.amschaton.InterfaceC1397bg;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.j */
/* loaded from: classes.dex */
class C1528j implements InterfaceC1397bg {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5356a;

    C1528j(AMSComposerActivity aMSComposerActivity) {
        this.f5356a = aMSComposerActivity;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: a */
    public boolean mo4926a() {
        this.f5356a.m5383f(false);
        this.f5356a.f5193N.m4963c();
        return true;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: b */
    public boolean mo4927b() throws Resources.NotFoundException {
        if (this.f5356a.f5193N.m4962b().getText().toString().length() > 0) {
            this.f5356a.f5180A.m4781a(this.f5356a.f5193N.m4958a(), this.f5356a.f5187H, this.f5356a.f5188I);
        }
        this.f5356a.m5383f(false);
        this.f5356a.f5193N.m4963c();
        return true;
    }
}
