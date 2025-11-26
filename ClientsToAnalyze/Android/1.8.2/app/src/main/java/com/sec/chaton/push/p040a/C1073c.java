package com.sec.chaton.push.p040a;

import com.sec.chaton.push.p041b.p043b.InterfaceC1088a;
import com.sec.chaton.push.p044c.C1111e;
import com.sec.chaton.push.util.C1139g;

/* compiled from: ErrorHandler.java */
/* renamed from: com.sec.chaton.push.a.c */
/* loaded from: classes.dex */
class C1073c implements InterfaceC1088a {

    /* renamed from: a */
    final /* synthetic */ C1072b f3995a;

    C1073c(C1072b c1072b) {
        this.f3995a = c1072b;
    }

    @Override // com.sec.chaton.push.p041b.p043b.InterfaceC1088a
    /* renamed from: a */
    public void mo4132a(boolean z, Throwable th) {
        if (C1139g.f4142a) {
            C1139g.m4308a(C1072b.f3984a, "Prov IChannelListener.onChannelDisconnected()");
        }
        if (Thread.currentThread() == C1111e.m4174a().m4187c()) {
            if (C1139g.f4142a) {
                C1139g.m4308a(C1072b.f3984a, "Thread is MessageTaskExecuteThread, execute directly.");
            }
            new RunnableC1079i(z, th).run();
        } else {
            if (C1139g.f4142a) {
                C1139g.m4308a(C1072b.f3984a, "Thread isn't MessageTaskExecuteThread, post disconnect hander.");
            }
            C1111e.m4174a().m4186b().postAtFrontOfQueue(new RunnableC1079i(z, th));
        }
    }

    @Override // com.sec.chaton.push.p041b.p043b.InterfaceC1088a
    /* renamed from: a */
    public void mo4131a() {
    }
}
