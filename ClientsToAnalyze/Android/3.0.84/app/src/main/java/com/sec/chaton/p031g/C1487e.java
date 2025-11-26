package com.sec.chaton.p031g;

import com.facebook.C0072am;
import com.facebook.C0085az;
import com.facebook.InterfaceC0077ar;
import com.sec.spp.push.dlc.api.DlcApi;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.g.e */
/* loaded from: classes.dex */
class C1487e implements InterfaceC0077ar {

    /* renamed from: a */
    final /* synthetic */ C1483a f5501a;

    C1487e(C1483a c1483a) {
        this.f5501a = c1483a;
    }

    @Override // com.facebook.InterfaceC0077ar
    /* renamed from: a */
    public void mo176a(C0085az c0085az) {
        C0072am c0072amM218c = c0085az.m218c();
        synchronized (this.f5501a.f5495f) {
            this.f5501a.f5495f.remove(c0072amM218c);
        }
        if (c0085az.m215a() != null) {
            this.f5501a.f5493d.mo9799a(1, DlcApi.RC_SVC_NOT_CONNECTED, c0085az.m215a().m114c());
        } else {
            this.f5501a.f5493d.mo9799a(1, -1, null);
        }
    }
}
