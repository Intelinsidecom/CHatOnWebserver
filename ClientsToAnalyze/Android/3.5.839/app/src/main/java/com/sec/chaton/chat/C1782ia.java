package com.sec.chaton.chat;

import com.sec.chaton.util.C4904y;
import java.util.TimerTask;

/* compiled from: TypingStateManager.java */
/* renamed from: com.sec.chaton.chat.ia */
/* loaded from: classes.dex */
class C1782ia extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ long f6687a;

    /* renamed from: b */
    final /* synthetic */ C1779hy f6688b;

    C1782ia(C1779hy c1779hy, long j) {
        this.f6688b = c1779hy;
        this.f6687a = j;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f6688b.f6679e;
        if (C4904y.f17873c) {
            C4904y.m18641c("Idle timer task - " + jCurrentTimeMillis, "TypingStateManager");
        }
        if (jCurrentTimeMillis >= this.f6687a) {
            this.f6688b.f6675a = EnumC1787if.IDLE;
            this.f6688b.f6680f.m9641a(EnumC1787if.m8817a(this.f6688b.f6675a), 65);
            this.f6688b.m8808e();
            return;
        }
        this.f6688b.m8800a(10000 - jCurrentTimeMillis);
    }
}
