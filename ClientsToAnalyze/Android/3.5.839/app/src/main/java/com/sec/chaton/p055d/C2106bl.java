package com.sec.chaton.p055d;

import com.sec.chaton.sns.p114b.InterfaceC4376ab;

/* compiled from: SnsAccountControl.java */
/* renamed from: com.sec.chaton.d.bl */
/* loaded from: classes.dex */
class C2106bl implements InterfaceC4376ab {

    /* renamed from: a */
    final /* synthetic */ C2105bk f7654a;

    C2106bl(C2105bk c2105bk) {
        this.f7654a = c2105bk;
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9435a(int i) {
        EnumC2111bq.m9446a(EnumC2111bq.SIGNING_UP);
        this.f7654a.m9398a(1302);
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: a */
    public void mo9434a() {
        EnumC2111bq.m9446a(EnumC2111bq.FINISH_SIGN_IN);
        this.f7654a.m9398a(1304);
    }

    @Override // com.sec.chaton.sns.p114b.InterfaceC4376ab
    /* renamed from: b */
    public void mo9436b() {
        this.f7654a.m9398a(1303);
    }
}
