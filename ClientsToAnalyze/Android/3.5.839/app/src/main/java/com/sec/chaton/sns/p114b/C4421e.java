package com.sec.chaton.sns.p114b;

import com.facebook.C0443am;
import com.facebook.C0456az;
import com.facebook.InterfaceC0448ar;
import com.sec.spp.push.dlc.api.DlcApi;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.sns.b.e */
/* loaded from: classes.dex */
class C4421e implements InterfaceC0448ar {

    /* renamed from: a */
    final /* synthetic */ C4374a f15976a;

    C4421e(C4374a c4374a) {
        this.f15976a = c4374a;
    }

    @Override // com.facebook.InterfaceC0448ar
    /* renamed from: a */
    public void mo1620a(C0456az c0456az) {
        C0443am c0443amM1662c = c0456az.m1662c();
        synchronized (this.f15976a.f15850f) {
            this.f15976a.f15850f.remove(c0443amM1662c);
        }
        if (c0456az.m1659a() != null) {
            this.f15976a.f15848d.mo16563a(1, DlcApi.RC_SVC_NOT_CONNECTED, c0456az.m1659a().m1558d());
        } else {
            this.f15976a.f15848d.mo16563a(1, -1, null);
        }
    }
}
