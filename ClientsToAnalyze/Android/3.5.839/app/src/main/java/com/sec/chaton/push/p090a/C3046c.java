package com.sec.chaton.push.p090a;

import com.sec.chaton.push.p091b.p093b.InterfaceC3061a;
import com.sec.chaton.push.p094c.C3084e;
import com.sec.chaton.push.util.C3115g;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.c */
/* loaded from: classes.dex */
class C3046c implements InterfaceC3061a {

    /* renamed from: a */
    final /* synthetic */ C3045b f11308a;

    C3046c(C3045b c3045b) {
        this.f11308a = c3045b;
    }

    @Override // com.sec.chaton.push.p091b.p093b.InterfaceC3061a
    /* renamed from: a */
    public void mo12519a(boolean z, Throwable th) {
        if (C3115g.f11458a) {
            C3115g.m12701a(C3045b.f11297a, "Prov IChannelListener.onChannelDisconnected()");
        }
        if (Thread.currentThread() == C3084e.m12562a().m12576c()) {
            if (C3115g.f11458a) {
                C3115g.m12701a(C3045b.f11297a, "Thread is MessageTaskExecuteThread, execute directly.");
            }
            new RunnableC3052i(z, th).run();
        } else {
            if (C3115g.f11458a) {
                C3115g.m12701a(C3045b.f11297a, "Thread isn't MessageTaskExecuteThread, post disconnect hander.");
            }
            C3084e.m12562a().m12575b().postAtFrontOfQueue(new RunnableC3052i(z, th));
        }
    }

    @Override // com.sec.chaton.push.p091b.p093b.InterfaceC3061a
    /* renamed from: a */
    public void mo12518a() {
    }
}
