package com.sec.chaton.push;

import android.os.RemoteException;
import com.sec.chaton.push.p094c.InterfaceC3081b;
import com.sec.chaton.push.util.C3115g;

/* compiled from: PushClientService.java */
/* renamed from: com.sec.chaton.push.p */
/* loaded from: classes.dex */
class C3104p implements InterfaceC3081b {

    /* renamed from: a */
    final /* synthetic */ InterfaceC3056b f11433a;

    /* renamed from: b */
    final /* synthetic */ BinderC3102n f11434b;

    C3104p(BinderC3102n binderC3102n, InterfaceC3056b interfaceC3056b) {
        this.f11434b = binderC3102n;
        this.f11433a = interfaceC3056b;
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3081b
    /* renamed from: a */
    public void mo12558a() {
        if (this.f11433a != null) {
            try {
                this.f11433a.mo9333a("Deregistration success");
            } catch (RemoteException e) {
                if (C3115g.f11461d) {
                    C3115g.m12702a(this.f11434b.f11430a.f11294a, e.getMessage(), e);
                }
            }
        }
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3081b
    /* renamed from: a */
    public void mo12559a(int i) {
        if (this.f11433a != null) {
            try {
                this.f11433a.mo9332a(i, "Deregistration fail.");
            } catch (RemoteException e) {
                if (C3115g.f11461d) {
                    C3115g.m12702a(this.f11434b.f11430a.f11294a, e.getMessage(), e);
                }
            }
        }
    }
}
