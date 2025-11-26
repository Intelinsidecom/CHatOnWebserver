package com.sec.chaton.push;

import com.sec.chaton.push.p050a.C2044a;
import com.sec.chaton.push.p050a.C2045b;
import com.sec.chaton.push.p051b.p052a.C2059c;
import com.sec.chaton.push.p051b.p052a.C2060d;
import com.sec.chaton.push.p054c.C2084e;
import com.sec.chaton.push.p054c.C2088i;
import com.sec.chaton.push.p054c.InterfaceC2090k;
import com.sec.chaton.push.util.C2115g;

/* compiled from: PushClientService.java */
/* renamed from: com.sec.chaton.push.m */
/* loaded from: classes.dex */
class RunnableC2101m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PushClientService f8019a;

    RunnableC2101m(PushClientService pushClientService) {
        this.f8019a = pushClientService;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushClientApplication pushClientApplication = (PushClientApplication) this.f8019a.getApplication();
        C2084e.m8219a().m8230a(-2);
        if (C2115g.f8048a) {
            C2115g.m8359a(this.f8019a.f7884a, "Cancel retry provisioning and initialize.");
        }
        C2045b.m8162a().m8168c();
        C2045b.m8162a().m8171f();
        C2088i.m8241a().m8245a(pushClientApplication, (InterfaceC2090k) null);
        try {
            if (C2115g.f8048a) {
                C2115g.m8359a(this.f8019a.f7884a, "Close provisioning connection.");
            }
            C2059c c2059cM8160k = pushClientApplication.m8160k();
            if (c2059cM8160k != null) {
                c2059cM8160k.mo8184b();
            }
        } catch (C2044a e) {
        }
        try {
            if (C2115g.f8048a) {
                C2115g.m8359a(this.f8019a.f7884a, "Close push connection.");
            }
            C2060d c2060dM8159j = pushClientApplication.m8159j();
            if (c2060dM8159j != null) {
                c2060dM8159j.mo8184b();
            }
        } catch (C2044a e2) {
        }
    }
}
