package com.sec.chaton.push.p044c;

import android.os.Message;
import com.sec.chaton.push.util.C1139g;

/* compiled from: MessageTaskDispatcher.java */
/* renamed from: com.sec.chaton.push.c.f */
/* loaded from: classes.dex */
class C1112f extends Thread {

    /* renamed from: a */
    final /* synthetic */ C1111e f4083a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1112f(C1111e c1111e, String str) {
        super(str);
        this.f4083a = c1111e;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean zSendMessage;
        while (true) {
            try {
                if (C1139g.f4143b) {
                    C1139g.m4311b(C1111e.f4074a, "Wating for taking message task from MessageTaskQueue.");
                }
                AbstractC1099a abstractC1099aM4205b = C1115i.m4196a().m4205b();
                if (C1139g.f4142a) {
                    C1139g.m4308a(C1111e.f4074a, String.format("Forward message task to MessageTaskExecuteHandler. task: %s. ", abstractC1099aM4205b));
                }
                synchronized (C1111e.f4075b) {
                    zSendMessage = this.f4083a.f4079f.sendMessage(Message.obtain(this.f4083a.f4079f, 0, abstractC1099aM4205b));
                }
                if (!zSendMessage && C1139g.f4144c) {
                    C1139g.m4312c(C1111e.f4074a, "Couldn't forward task to MessageTaskExecuteHandler. Is Message Task Execute Handler quit?");
                    C1139g.m4312c(C1111e.f4074a, "Quit MessageTaskDispatcherThread.");
                    return;
                } else {
                    synchronized (this) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                if (C1139g.f4145d) {
                    C1139g.m4309a(C1111e.f4074a, e.getMessage(), e);
                    return;
                }
                return;
            }
        }
    }
}
