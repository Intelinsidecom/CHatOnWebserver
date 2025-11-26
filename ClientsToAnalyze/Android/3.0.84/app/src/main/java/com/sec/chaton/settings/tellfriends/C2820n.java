package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.settings.tellfriends.common.AsyncTaskC2801q;
import com.sec.chaton.settings.tellfriends.common.C2785a;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2786b;

/* compiled from: RenrenManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.n */
/* loaded from: classes.dex */
class C2820n implements InterfaceC2786b {

    /* renamed from: a */
    final /* synthetic */ int f10346a;

    /* renamed from: b */
    final /* synthetic */ C2819m f10347b;

    C2820n(C2819m c2819m, int i) {
        this.f10347b = c2819m;
        this.f10346a = i;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2786b
    /* renamed from: a */
    public void mo540a(C2785a c2785a) {
        this.f10347b.m10015c("Login Request:" + this.f10346a + " Webview Error. " + c2785a.getMessage());
        if (c2785a.m9994a() != -1002) {
            this.f10347b.f10301c.mo9799a(this.f10346a, c2785a.m9994a(), c2785a.getMessage());
        } else {
            this.f10347b.f10301c.mo9799a(this.f10346a, -1002, c2785a.getMessage());
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2786b
    /* renamed from: a */
    public void mo541a(Object obj) {
        this.f10347b.m10014b("Login Request:" + this.f10346a + " Done.");
        new AsyncTaskC2801q(this.f10347b, this.f10346a).execute(new C2823q(this.f10347b, null));
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2786b
    /* renamed from: a */
    public void mo539a() {
        this.f10347b.m10014b("Login Request:" + this.f10346a + " Canceled.");
        this.f10347b.f10301c.mo9799a(this.f10346a, 0, null);
    }
}
