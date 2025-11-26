package com.sec.chaton.p031g;

import com.facebook.C0072am;
import com.facebook.C0085az;
import com.facebook.InterfaceC0078as;
import com.facebook.model.GraphCustomUser;
import com.sec.spp.push.dlc.api.DlcApi;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.g.c */
/* loaded from: classes.dex */
class C1485c implements InterfaceC0078as {

    /* renamed from: a */
    final /* synthetic */ C1483a f5499a;

    C1485c(C1483a c1483a) {
        this.f5499a = c1483a;
    }

    @Override // com.facebook.InterfaceC0078as
    /* renamed from: a */
    public void mo178a(GraphCustomUser graphCustomUser, C0085az c0085az) {
        C0072am c0072amM218c = c0085az.m218c();
        synchronized (this.f5499a.f5495f) {
            this.f5499a.f5495f.remove(c0072amM218c);
        }
        if (c0085az.m215a() != null) {
            this.f5499a.f5493d.mo9799a(3, DlcApi.RC_SVC_NOT_CONNECTED, c0085az.m215a().m114c());
        } else {
            this.f5499a.m6419a(graphCustomUser);
            this.f5499a.f5493d.mo9799a(3, -1, null);
        }
    }
}
