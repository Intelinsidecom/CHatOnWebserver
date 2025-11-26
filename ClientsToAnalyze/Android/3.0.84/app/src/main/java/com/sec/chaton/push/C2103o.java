package com.sec.chaton.push;

import android.os.RemoteException;
import com.sec.chaton.push.p054c.InterfaceC2081b;
import com.sec.chaton.push.util.C2115g;

/* compiled from: PushClientService.java */
/* renamed from: com.sec.chaton.push.o */
/* loaded from: classes.dex */
class C2103o implements InterfaceC2081b {

    /* renamed from: a */
    final /* synthetic */ InterfaceC2095h f8021a;

    /* renamed from: b */
    final /* synthetic */ BinderC2102n f8022b;

    C2103o(BinderC2102n binderC2102n, InterfaceC2095h interfaceC2095h) {
        this.f8022b = binderC2102n;
        this.f8021a = interfaceC2095h;
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2081b
    /* renamed from: a */
    public void mo8215a() {
        if (this.f8021a != null) {
            try {
                this.f8021a.mo5593a("Registration success", C2099k.m8309f((String) null));
            } catch (RemoteException e) {
                if (C2115g.f8051d) {
                    C2115g.m8360a(this.f8022b.f8020a.f7884a, e.getMessage(), e);
                }
            }
        }
    }

    @Override // com.sec.chaton.push.p054c.InterfaceC2081b
    /* renamed from: a */
    public void mo8216a(int i) {
        if (this.f8021a != null) {
            try {
                this.f8021a.mo5592a(i, "Registration fail.");
            } catch (RemoteException e) {
                if (C2115g.f8051d) {
                    C2115g.m8360a(this.f8022b.f8020a.f7884a, e.getMessage(), e);
                }
            }
        }
    }
}
