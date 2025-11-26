package com.sec.chaton.push;

import android.os.RemoteException;
import com.sec.chaton.push.p044c.InterfaceC1108b;
import com.sec.chaton.push.util.C1139g;

/* compiled from: PushClientService.java */
/* renamed from: com.sec.chaton.push.m */
/* loaded from: classes.dex */
class C1129m implements InterfaceC1108b {

    /* renamed from: a */
    final /* synthetic */ InterfaceC1070a f4113a;

    /* renamed from: b */
    final /* synthetic */ BinderC1127k f4114b;

    C1129m(BinderC1127k binderC1127k, InterfaceC1070a interfaceC1070a) {
        this.f4114b = binderC1127k;
        this.f4113a = interfaceC1070a;
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1108b
    /* renamed from: a */
    public void mo4170a() {
        if (this.f4113a != null) {
            try {
                this.f4113a.mo2800a("Deregistration success");
            } catch (RemoteException e) {
                if (C1139g.f4145d) {
                    C1139g.m4309a(this.f4114b.f4110a.f3982a, e.getMessage(), e);
                }
            }
        }
    }

    @Override // com.sec.chaton.push.p044c.InterfaceC1108b
    /* renamed from: a */
    public void mo4171a(int i) {
        if (this.f4113a != null) {
            try {
                this.f4113a.mo2799a(i, "Deregistration fail.");
            } catch (RemoteException e) {
                if (C1139g.f4145d) {
                    C1139g.m4309a(this.f4114b.f4110a.f3982a, e.getMessage(), e);
                }
            }
        }
    }
}
