package com.sec.chaton.sns.p114b;

import com.sec.chaton.sns.p113a.C4365b;
import com.sec.chaton.sns.p113a.InterfaceC4366c;

/* compiled from: RenrenManager.java */
/* renamed from: com.sec.chaton.sns.b.r */
/* loaded from: classes.dex */
class C4434r implements InterfaceC4366c {

    /* renamed from: a */
    final /* synthetic */ int f16005a;

    /* renamed from: b */
    final /* synthetic */ C4432p f16006b;

    C4434r(C4432p c4432p, int i) {
        this.f16006b = c4432p;
        this.f16005a = i;
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2272a(C4365b c4365b) {
        this.f16006b.m16572b("Post Request:" + this.f16005a + " Webview Error. " + c4365b.getMessage());
        if (c4365b.m16562a() != -1002) {
            this.f16006b.f15831b.mo16563a(this.f16005a, c4365b.m16562a(), c4365b.getMessage());
        } else {
            this.f16006b.f15831b.mo16563a(this.f16005a, -1002, c4365b.getMessage());
        }
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2273a(Object obj) {
        this.f16006b.m16571a("Post Request:" + this.f16005a + " Done.");
        this.f16006b.f15831b.mo16563a(this.f16005a, -1, obj);
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2271a() {
        this.f16006b.m16571a("Post Request:" + this.f16005a + " Canceled.");
        this.f16006b.f15831b.mo16563a(this.f16005a, 0, null);
    }
}
