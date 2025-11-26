package com.sec.chaton.p055d;

import com.sec.chaton.sns.p114b.InterfaceC4441y;
import com.sec.chaton.util.C4904y;

/* compiled from: SnsAccountControl.java */
/* renamed from: com.sec.chaton.d.bn */
/* loaded from: classes.dex */
class C2108bn implements InterfaceC4441y {

    /* renamed from: a */
    final /* synthetic */ C2105bk f7656a;

    C2108bn(C2105bk c2105bk) {
        this.f7656a = c2105bk;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4441y
    /* renamed from: a */
    public void mo9442a(Object obj) {
        C4904y.m18639b("onComplete get friend IDs", getClass().getSimpleName());
        if (obj instanceof long[]) {
            this.f7656a.f7650n = (long[]) obj;
        }
        if (this.f7656a.f7650n.length <= 0) {
            this.f7656a.m9398a(1301);
        } else {
            this.f7656a.m9419n();
        }
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4441y
    /* renamed from: a */
    public void mo9440a() {
        C4904y.m18639b("onComplete get friend IDs", getClass().getSimpleName());
        this.f7656a.m9398a(1303);
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4441y
    /* renamed from: a */
    public void mo9441a(int i) {
        C4904y.m18639b("onComplete get friend IDs", getClass().getSimpleName());
        this.f7656a.m9398a(1302);
    }
}
