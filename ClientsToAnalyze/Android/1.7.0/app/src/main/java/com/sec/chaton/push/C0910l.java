package com.sec.chaton.push;

import android.os.RemoteException;
import com.sec.chaton.push.p039c.InterfaceC0898j;
import com.sec.chaton.push.util.C0921g;

/* compiled from: PushClientService.java */
/* renamed from: com.sec.chaton.push.l */
/* loaded from: classes.dex */
class C0910l implements InterfaceC0898j {

    /* renamed from: a */
    final /* synthetic */ InterfaceC0880c f3090a;

    /* renamed from: b */
    final /* synthetic */ BinderC0900d f3091b;

    C0910l(BinderC0900d binderC0900d, InterfaceC0880c interfaceC0880c) {
        this.f3091b = binderC0900d;
        this.f3090a = interfaceC0880c;
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0898j
    /* renamed from: a */
    public void mo3531a() {
        if (this.f3090a != null) {
            try {
                this.f3090a.mo805a("Deregistration success");
            } catch (RemoteException e) {
                if (C0921g.f3119d) {
                    C0921g.m3638a(this.f3091b.f3073a.f2960a, e.getMessage(), e);
                }
            }
        }
    }

    @Override // com.sec.chaton.push.p039c.InterfaceC0898j
    /* renamed from: a */
    public void mo3532a(int i) {
        if (this.f3090a != null) {
            try {
                this.f3090a.mo804a(i, "Deregistration fail.");
            } catch (RemoteException e) {
                if (C0921g.f3119d) {
                    C0921g.m3638a(this.f3091b.f3073a.f2960a, e.getMessage(), e);
                }
            }
        }
    }
}
