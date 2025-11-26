package com.sec.chaton.push.p094c;

import android.os.Message;
import com.sec.chaton.push.util.C3115g;

/* compiled from: MessageTaskDispatcher.java */
/* renamed from: com.sec.chaton.push.c.f */
/* loaded from: classes.dex */
class C3085f extends Thread {

    /* renamed from: a */
    final /* synthetic */ C3084e f11397a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3085f(C3084e c3084e, String str) {
        super(str);
        this.f11397a = c3084e;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            try {
                if (C3115g.f11459b) {
                    C3115g.m12704b(C3084e.f11387a, "Wating for taking message task from MessageTaskQueue.");
                }
                AbstractC3072a abstractC3072aM12593b = C3088i.m12584a().m12593b();
                if (C3115g.f11458a) {
                    C3115g.m12701a(C3084e.f11387a, String.format("Forward message task to MessageTaskExecuteHandler. task: %s. ", abstractC3072aM12593b));
                }
                if (!this.f11397a.f11393g.sendMessage(Message.obtain(this.f11397a.f11393g, 0, abstractC3072aM12593b)) && C3115g.f11460c) {
                    C3115g.m12705c(C3084e.f11387a, "Couldn't forward task to MessageTaskExecuteHandler. Is Message Task Execute Handler quit?");
                    C3115g.m12705c(C3084e.f11387a, "Quit MessageTaskDispatcherThread.");
                    return;
                } else {
                    synchronized (this) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                if (C3115g.f11461d) {
                    C3115g.m12702a(C3084e.f11387a, e.getMessage(), e);
                    return;
                }
                return;
            }
        }
    }
}
