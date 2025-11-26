package com.sec.chaton.settings.tellfriends;

import com.sec.chaton.settings.tellfriends.common.C2785a;
import com.sec.chaton.settings.tellfriends.common.InterfaceC2786b;

/* compiled from: RenrenManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.o */
/* loaded from: classes.dex */
class C2821o implements InterfaceC2786b {

    /* renamed from: a */
    final /* synthetic */ int f10348a;

    /* renamed from: b */
    final /* synthetic */ C2819m f10349b;

    C2821o(C2819m c2819m, int i) {
        this.f10349b = c2819m;
        this.f10348a = i;
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2786b
    /* renamed from: a */
    public void mo540a(C2785a c2785a) {
        this.f10349b.m10015c("Post Request:" + this.f10348a + " Webview Error. " + c2785a.getMessage());
        if (c2785a.m9994a() != -1002) {
            this.f10349b.f10301c.mo9799a(this.f10348a, c2785a.m9994a(), c2785a.getMessage());
        } else {
            this.f10349b.f10301c.mo9799a(this.f10348a, -1002, c2785a.getMessage());
        }
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2786b
    /* renamed from: a */
    public void mo541a(Object obj) {
        this.f10349b.m10014b("Post Request:" + this.f10348a + " Done.");
        this.f10349b.f10301c.mo9799a(this.f10348a, -1, obj);
    }

    @Override // com.sec.chaton.settings.tellfriends.common.InterfaceC2786b
    /* renamed from: a */
    public void mo539a() {
        this.f10349b.m10014b("Post Request:" + this.f10348a + " Canceled.");
        this.f10349b.f10301c.mo9799a(this.f10348a, 0, null);
    }
}
