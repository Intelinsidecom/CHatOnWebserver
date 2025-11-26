package com.sec.chaton.p031g;

import com.facebook.C0072am;
import com.facebook.C0085az;
import com.facebook.InterfaceC0079at;
import com.facebook.model.GraphCustomUser;
import com.sec.spp.push.dlc.api.DlcApi;
import java.util.List;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.g.d */
/* loaded from: classes.dex */
class C1486d implements InterfaceC0079at {

    /* renamed from: a */
    final /* synthetic */ C1483a f5500a;

    C1486d(C1483a c1483a) {
        this.f5500a = c1483a;
    }

    @Override // com.facebook.InterfaceC0079at
    /* renamed from: a */
    public void mo179a(List<GraphCustomUser> list, C0085az c0085az) {
        C0072am c0072amM218c = c0085az.m218c();
        synchronized (this.f5500a.f5495f) {
            this.f5500a.f5495f.remove(c0072amM218c);
        }
        if (c0085az.m215a() != null) {
            this.f5500a.f5493d.mo9799a(0, DlcApi.RC_SVC_NOT_CONNECTED, c0085az.m215a().m114c());
        } else {
            this.f5500a.f5493d.mo9799a(0, -1, list);
        }
    }
}
