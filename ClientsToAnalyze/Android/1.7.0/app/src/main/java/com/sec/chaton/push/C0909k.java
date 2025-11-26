package com.sec.chaton.push;

import android.os.RemoteException;
import com.sec.chaton.push.p039c.InterfaceC0898j;
import com.sec.chaton.push.util.C0921g;

/* compiled from: PushClientService.java */
/* renamed from: com.sec.chaton.push.k */
/* loaded from: classes.dex */
class C0909k implements InterfaceC0898j {

    /* renamed from: a */
    final /* synthetic */ InterfaceC0902f f3088a;

    /* renamed from: b */
    final /* synthetic */ BinderC0900d f3089b;

    C0909k(BinderC0900d binderC0900d, InterfaceC0902f interfaceC0902f) {
        this.f3089b = binderC0900d;
        this.f3088a = interfaceC0902f;
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0898j
    /* renamed from: a */
    public void mo3531a() {
        if (this.f3088a != null) {
            try {
                this.f3088a.mo728a("Registration success", C0904h.m3562f((String) null));
            } catch (RemoteException e) {
                if (C0921g.f3119d) {
                    C0921g.m3638a(this.f3089b.f3073a.f2960a, e.getMessage(), e);
                }
            }
        }
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0898j
    /* renamed from: a */
    public void mo3532a(int i) {
        if (this.f3088a != null) {
            try {
                this.f3088a.mo727a(i, "Registration fail.");
            } catch (RemoteException e) {
                if (C0921g.f3119d) {
                    C0921g.m3638a(this.f3089b.f3073a.f2960a, e.getMessage(), e);
                }
            }
        }
    }
}
