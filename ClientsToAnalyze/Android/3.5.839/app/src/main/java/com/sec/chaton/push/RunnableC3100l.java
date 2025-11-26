package com.sec.chaton.push;

import com.sec.chaton.push.p094c.C3088i;
import com.sec.chaton.push.p094c.p095a.C3074b;
import com.sec.chaton.push.util.C3115g;
import com.sec.common.CommonApplication;

/* compiled from: PushClientService.java */
/* renamed from: com.sec.chaton.push.l */
/* loaded from: classes.dex */
class RunnableC3100l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PushClientService f11428a;

    RunnableC3100l(PushClientService pushClientService) {
        this.f11428a = pushClientService;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!C3074b.m12543d()) {
                if (C3115g.f11458a) {
                    C3115g.m12701a(this.f11428a.f11294a, "PushModule hasn't been initialized. Execute initialize.");
                }
                C3088i.m12584a().m12591a(new C3074b(CommonApplication.m18732r()));
            } else if (C3115g.f11458a) {
                C3115g.m12701a(this.f11428a.f11294a, "PushModule has been initialized.");
            }
        } catch (InterruptedException e) {
            if (C3115g.f11461d) {
                C3115g.m12702a(this.f11428a.f11294a, e.getMessage(), e);
            }
        }
    }
}
