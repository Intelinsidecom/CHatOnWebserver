package com.sec.chaton.push;

import com.sec.chaton.push.p090a.C3044a;
import com.sec.chaton.push.p090a.C3045b;
import com.sec.chaton.push.p091b.p092a.C3059c;
import com.sec.chaton.push.p091b.p092a.C3060d;
import com.sec.chaton.push.p094c.C3084e;
import com.sec.chaton.push.p094c.C3088i;
import com.sec.chaton.push.p094c.InterfaceC3090k;
import com.sec.chaton.push.util.C3115g;

/* compiled from: PushClientService.java */
/* renamed from: com.sec.chaton.push.m */
/* loaded from: classes.dex */
class RunnableC3101m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PushClientService f11429a;

    RunnableC3101m(PushClientService pushClientService) {
        this.f11429a = pushClientService;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushClientApplication pushClientApplication = (PushClientApplication) this.f11429a.getApplication();
        C3084e.m12562a().m12573a(-2);
        if (C3115g.f11458a) {
            C3115g.m12701a(this.f11429a.f11294a, "Cancel retry provisioning and initialize.");
        }
        C3045b.m12505a().m12511c();
        C3045b.m12505a().m12514f();
        C3088i.m12584a().m12588a(pushClientApplication, (InterfaceC3090k) null);
        try {
            if (C3115g.f11458a) {
                C3115g.m12701a(this.f11429a.f11294a, "Close provisioning connection.");
            }
            C3059c c3059cM12503q = pushClientApplication.m12503q();
            if (c3059cM12503q != null) {
                c3059cM12503q.mo12527b();
            }
        } catch (C3044a e) {
        }
        try {
            if (C3115g.f11458a) {
                C3115g.m12701a(this.f11429a.f11294a, "Close push connection.");
            }
            C3060d c3060dM12502p = pushClientApplication.m12502p();
            if (c3060dM12502p != null) {
                c3060dM12502p.mo12527b();
            }
        } catch (C3044a e2) {
        }
    }
}
