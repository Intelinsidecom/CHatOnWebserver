package com.sec.chaton.push;

import android.os.RemoteException;
import com.sec.chaton.push.p044c.InterfaceC1108b;
import com.sec.chaton.push.util.C1139g;

/* compiled from: PushClientService.java */
/* renamed from: com.sec.chaton.push.l */
/* loaded from: classes.dex */
class C1128l implements InterfaceC1108b {

    /* renamed from: a */
    final /* synthetic */ InterfaceC1121g f4111a;

    /* renamed from: b */
    final /* synthetic */ BinderC1127k f4112b;

    C1128l(BinderC1127k binderC1127k, InterfaceC1121g interfaceC1121g) {
        this.f4112b = binderC1127k;
        this.f4111a = interfaceC1121g;
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1108b
    /* renamed from: a */
    public void mo4170a() {
        if (this.f4111a != null) {
            try {
                this.f4111a.mo2803a("Registration success", C1126j.m4264f((String) null));
            } catch (RemoteException e) {
                if (C1139g.f4145d) {
                    C1139g.m4309a(this.f4112b.f4110a.f3982a, e.getMessage(), e);
                }
            }
        }
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1108b
    /* renamed from: a */
    public void mo4171a(int i) {
        if (this.f4111a != null) {
            try {
                this.f4111a.mo2802a(i, "Registration fail.");
            } catch (RemoteException e) {
                if (C1139g.f4145d) {
                    C1139g.m4309a(this.f4112b.f4110a.f3982a, e.getMessage(), e);
                }
            }
        }
    }
}
