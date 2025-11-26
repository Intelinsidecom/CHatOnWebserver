package com.sec.chaton.push;

import android.os.RemoteException;
import com.sec.chaton.push.p054c.InterfaceC2081b;
import com.sec.chaton.push.util.C2115g;

/* compiled from: PushClientService.java */
/* renamed from: com.sec.chaton.push.p */
/* loaded from: classes.dex */
class C2104p implements InterfaceC2081b {

    /* renamed from: a */
    final /* synthetic */ InterfaceC2056b f8023a;

    /* renamed from: b */
    final /* synthetic */ BinderC2102n f8024b;

    C2104p(BinderC2102n binderC2102n, InterfaceC2056b interfaceC2056b) {
        this.f8024b = binderC2102n;
        this.f8023a = interfaceC2056b;
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2081b
    /* renamed from: a */
    public void mo8215a() {
        if (this.f8023a != null) {
            try {
                this.f8023a.mo5590a("Deregistration success");
            } catch (RemoteException e) {
                if (C2115g.f8051d) {
                    C2115g.m8360a(this.f8024b.f8020a.f7884a, e.getMessage(), e);
                }
            }
        }
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2081b
    /* renamed from: a */
    public void mo8216a(int i) {
        if (this.f8023a != null) {
            try {
                this.f8023a.mo5589a(i, "Deregistration fail.");
            } catch (RemoteException e) {
                if (C2115g.f8051d) {
                    C2115g.m8360a(this.f8024b.f8020a.f7884a, e.getMessage(), e);
                }
            }
        }
    }
}
