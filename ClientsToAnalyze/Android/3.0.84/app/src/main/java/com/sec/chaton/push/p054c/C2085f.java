package com.sec.chaton.push.p054c;

import android.os.Message;
import com.sec.chaton.push.util.C2115g;

/* compiled from: MessageTaskDispatcher.java */
/* renamed from: com.sec.chaton.push.c.f */
/* loaded from: classes.dex */
class C2085f extends Thread {

    /* renamed from: a */
    final /* synthetic */ C2084e f7987a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2085f(C2084e c2084e, String str) {
        super(str);
        this.f7987a = c2084e;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            try {
                if (C2115g.f8049b) {
                    C2115g.m8362b(C2084e.f7977a, "Wating for taking message task from MessageTaskQueue.");
                }
                AbstractC2072a abstractC2072aM8250b = C2088i.m8241a().m8250b();
                if (C2115g.f8048a) {
                    C2115g.m8359a(C2084e.f7977a, String.format("Forward message task to MessageTaskExecuteHandler. task: %s. ", abstractC2072aM8250b));
                }
                if (!this.f7987a.f7983g.sendMessage(Message.obtain(this.f7987a.f7983g, 0, abstractC2072aM8250b)) && C2115g.f8050c) {
                    C2115g.m8363c(C2084e.f7977a, "Couldn't forward task to MessageTaskExecuteHandler. Is Message Task Execute Handler quit?");
                    C2115g.m8363c(C2084e.f7977a, "Quit MessageTaskDispatcherThread.");
                    return;
                } else {
                    synchronized (this) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                if (C2115g.f8051d) {
                    C2115g.m8360a(C2084e.f7977a, e.getMessage(), e);
                    return;
                }
                return;
            }
        }
    }
}
