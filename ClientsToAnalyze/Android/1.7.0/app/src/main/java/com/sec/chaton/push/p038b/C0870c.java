package com.sec.chaton.push.p038b;

import com.sec.chaton.push.p035a.p036a.InterfaceC0855c;
import com.sec.chaton.push.p039c.C0893e;
import com.sec.chaton.push.util.C0921g;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.b.c */
/* loaded from: classes.dex */
class C0870c implements InterfaceC0855c {

    /* renamed from: a */
    final /* synthetic */ C0879l f3000a;

    C0870c(C0879l c0879l) {
        this.f3000a = c0879l;
    }

    @Override // com.sec.chaton.push.p035a.p036a.InterfaceC0855c
    /* renamed from: a */
    public void mo3449a(boolean z, Throwable th) {
        if (C0921g.f3116a) {
            C0921g.m3637a(C0879l.f3008a, "Push IChannelListener.onChannelDisconnected()");
        }
        if (Thread.currentThread() == C0893e.m3502a().m3515c()) {
            if (C0921g.f3116a) {
                C0921g.m3637a(C0879l.f3008a, "Thread is MessageTaskExecuteThread, execute directly.");
            }
            new RunnableC0868a(z, th).run();
        } else {
            if (C0921g.f3116a) {
                C0921g.m3637a(C0879l.f3008a, "Thread isn't MessageTaskExecuteThread, post disconnect hander.");
            }
            C0893e.m3502a().m3514b().postAtFrontOfQueue(new RunnableC0868a(z, th));
        }
    }

    @Override // com.sec.chaton.push.p035a.p036a.InterfaceC0855c
    /* renamed from: a */
    public void mo3448a() {
    }
}
