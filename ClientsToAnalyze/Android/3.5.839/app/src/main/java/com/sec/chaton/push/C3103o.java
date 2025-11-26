package com.sec.chaton.push;

import android.os.RemoteException;
import com.sec.chaton.push.p094c.InterfaceC3081b;
import com.sec.chaton.push.util.C3115g;

/* compiled from: PushClientService.java */
/* renamed from: com.sec.chaton.push.o */
/* loaded from: classes.dex */
class C3103o implements InterfaceC3081b {

    /* renamed from: a */
    final /* synthetic */ InterfaceC3095h f11431a;

    /* renamed from: b */
    final /* synthetic */ BinderC3102n f11432b;

    C3103o(BinderC3102n binderC3102n, InterfaceC3095h interfaceC3095h) {
        this.f11432b = binderC3102n;
        this.f11431a = interfaceC3095h;
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3081b
    /* renamed from: a */
    public void mo12558a() {
        if (this.f11431a != null) {
            try {
                this.f11431a.mo9336a("Registration success", C3099k.m12651f((String) null));
            } catch (RemoteException e) {
                if (C3115g.f11461d) {
                    C3115g.m12702a(this.f11432b.f11430a.f11294a, e.getMessage(), e);
                }
            }
        }
    }

    @Override // com.sec.chaton.push.p094c.InterfaceC3081b
    /* renamed from: a */
    public void mo12559a(int i) {
        if (this.f11431a != null) {
            try {
                this.f11431a.mo9335a(i, "Registration fail.");
            } catch (RemoteException e) {
                if (C3115g.f11461d) {
                    C3115g.m12702a(this.f11432b.f11430a.f11294a, e.getMessage(), e);
                }
            }
        }
    }
}
