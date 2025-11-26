package com.sec.chaton.push;

import com.sec.chaton.push.p054c.C2088i;
import com.sec.chaton.push.p054c.p055a.C2074b;
import com.sec.chaton.push.util.C2115g;
import com.sec.common.CommonApplication;

/* compiled from: PushClientService.java */
/* renamed from: com.sec.chaton.push.l */
/* loaded from: classes.dex */
class RunnableC2100l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ PushClientService f8018a;

    RunnableC2100l(PushClientService pushClientService) {
        this.f8018a = pushClientService;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!C2074b.m8200d()) {
                if (C2115g.f8048a) {
                    C2115g.m8359a(this.f8018a.f7884a, "PushModule hasn't been initialized. Execute initialize.");
                }
                C2088i.m8241a().m8248a(new C2074b(CommonApplication.m11493l()));
            } else if (C2115g.f8048a) {
                C2115g.m8359a(this.f8018a.f7884a, "PushModule has been initialized.");
            }
        } catch (InterruptedException e) {
            if (C2115g.f8051d) {
                C2115g.m8360a(this.f8018a.f7884a, e.getMessage(), e);
            }
        }
    }
}
