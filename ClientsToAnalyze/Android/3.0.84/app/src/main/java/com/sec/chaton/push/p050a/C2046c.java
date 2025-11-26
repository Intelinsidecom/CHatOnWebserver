package com.sec.chaton.push.p050a;

import com.sec.chaton.push.p051b.p053b.InterfaceC2061a;
import com.sec.chaton.push.p054c.C2084e;
import com.sec.chaton.push.util.C2115g;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.c */
/* loaded from: classes.dex */
class C2046c implements InterfaceC2061a {

    /* renamed from: a */
    final /* synthetic */ C2045b f7898a;

    C2046c(C2045b c2045b) {
        this.f7898a = c2045b;
    }

    @Override // com.sec.chaton.push.p051b.p053b.InterfaceC2061a
    /* renamed from: a */
    public void mo8176a(boolean z, Throwable th) {
        if (C2115g.f8048a) {
            C2115g.m8359a(C2045b.f7887a, "Prov IChannelListener.onChannelDisconnected()");
        }
        if (Thread.currentThread() == C2084e.m8219a().m8233c()) {
            if (C2115g.f8048a) {
                C2115g.m8359a(C2045b.f7887a, "Thread is MessageTaskExecuteThread, execute directly.");
            }
            new RunnableC2052i(z, th).run();
        } else {
            if (C2115g.f8048a) {
                C2115g.m8359a(C2045b.f7887a, "Thread isn't MessageTaskExecuteThread, post disconnect hander.");
            }
            C2084e.m8219a().m8232b().postAtFrontOfQueue(new RunnableC2052i(z, th));
        }
    }

    @Override // com.sec.chaton.push.p051b.p053b.InterfaceC2061a
    /* renamed from: a */
    public void mo8175a() {
    }
}
