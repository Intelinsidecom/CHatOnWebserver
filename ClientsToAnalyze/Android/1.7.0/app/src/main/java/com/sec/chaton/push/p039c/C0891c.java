package com.sec.chaton.push.p039c;

import android.os.Message;
import com.sec.chaton.push.util.C0921g;

/* compiled from: MessageTaskDispatcher.java */
/* renamed from: com.sec.chaton.push.c.c */
/* loaded from: classes.dex */
class C0891c extends Thread {

    /* renamed from: a */
    final /* synthetic */ C0893e f3053a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0891c(C0893e c0893e, String str) {
        super(str);
        this.f3053a = c0893e;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean zSendMessage;
        while (true) {
            try {
                if (C0921g.f3117b) {
                    C0921g.m3640b(C0893e.f3054a, "Wating for taking message task from MessageTaskQueue.");
                }
                AbstractC0894f abstractC0894fM3529b = C0896h.m3520a().m3529b();
                if (C0921g.f3116a) {
                    C0921g.m3637a(C0893e.f3054a, String.format("Forward message task to MessageTaskExecuteHandler. task: %s. ", abstractC0894fM3529b));
                }
                synchronized (C0893e.f3055b) {
                    zSendMessage = this.f3053a.f3059f.sendMessage(Message.obtain(this.f3053a.f3059f, 0, abstractC0894fM3529b));
                }
                if (!zSendMessage && C0921g.f3118c) {
                    C0921g.m3641c(C0893e.f3054a, "Couldn't forward task to MessageTaskExecuteHandler. Is Message Task Execute Handler quit?");
                    C0921g.m3641c(C0893e.f3054a, "Quit MessageTaskDispatcherThread.");
                    return;
                } else {
                    synchronized (this) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                if (C0921g.f3119d) {
                    C0921g.m3638a(C0893e.f3054a, e.getMessage(), e);
                    return;
                }
                return;
            }
        }
    }
}
