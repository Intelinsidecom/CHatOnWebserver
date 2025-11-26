package com.sec.chaton.sns.p114b;

import com.facebook.C0443am;
import com.facebook.C0456az;
import com.facebook.InterfaceC0449as;
import com.facebook.model.GraphCustomUser;
import com.sec.spp.push.dlc.api.DlcApi;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.sns.b.c */
/* loaded from: classes.dex */
class C4419c implements InterfaceC0449as {

    /* renamed from: a */
    final /* synthetic */ C4374a f15974a;

    C4419c(C4374a c4374a) {
        this.f15974a = c4374a;
    }

    @Override // com.facebook.InterfaceC0449as
    /* renamed from: a */
    public void mo1622a(GraphCustomUser graphCustomUser, C0456az c0456az) {
        C0443am c0443amM1662c = c0456az.m1662c();
        synchronized (this.f15974a.f15850f) {
            this.f15974a.f15850f.remove(c0443amM1662c);
        }
        if (c0456az.m1659a() != null) {
            this.f15974a.f15848d.mo16563a(3, DlcApi.RC_SVC_NOT_CONNECTED, c0456az.m1659a().m1558d());
        } else {
            this.f15974a.m16589a(graphCustomUser);
            this.f15974a.f15848d.mo16563a(3, -1, null);
        }
    }
}
