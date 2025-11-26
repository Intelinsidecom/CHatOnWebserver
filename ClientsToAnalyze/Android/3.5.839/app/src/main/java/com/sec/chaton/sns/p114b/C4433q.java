package com.sec.chaton.sns.p114b;

import com.sec.chaton.sns.p113a.AsyncTaskC4371h;
import com.sec.chaton.sns.p113a.C4365b;
import com.sec.chaton.sns.p113a.InterfaceC4366c;

/* compiled from: RenrenManager.java */
/* renamed from: com.sec.chaton.sns.b.q */
/* loaded from: classes.dex */
class C4433q implements InterfaceC4366c {

    /* renamed from: a */
    final /* synthetic */ int f16003a;

    /* renamed from: b */
    final /* synthetic */ C4432p f16004b;

    C4433q(C4432p c4432p, int i) {
        this.f16004b = c4432p;
        this.f16003a = i;
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2272a(C4365b c4365b) {
        this.f16004b.m16572b("Login Request:" + this.f16003a + " Webview Error. " + c4365b.getMessage());
        if (c4365b.m16562a() != -1002) {
            this.f16004b.f15831b.mo16563a(this.f16003a, c4365b.m16562a(), c4365b.getMessage());
        } else {
            this.f16004b.f15831b.mo16563a(this.f16003a, -1002, c4365b.getMessage());
        }
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2273a(Object obj) {
        this.f16004b.m16571a("Login Request:" + this.f16003a + " Done.");
        new AsyncTaskC4371h(this.f16004b, this.f16003a).execute(new C4436t(this.f16004b, null));
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2271a() {
        this.f16004b.m16571a("Login Request:" + this.f16003a + " Canceled.");
        this.f16004b.f15831b.mo16563a(this.f16003a, 0, null);
    }
}
