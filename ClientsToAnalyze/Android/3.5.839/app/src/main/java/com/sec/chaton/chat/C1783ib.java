package com.sec.chaton.chat;

import android.os.Handler;
import android.os.Looper;
import java.util.TimerTask;

/* compiled from: TypingStateManager.java */
/* renamed from: com.sec.chaton.chat.ib */
/* loaded from: classes.dex */
class C1783ib extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ long f6689a;

    /* renamed from: b */
    final /* synthetic */ long f6690b;

    /* renamed from: c */
    final /* synthetic */ String f6691c;

    /* renamed from: d */
    final /* synthetic */ C1779hy f6692d;

    C1783ib(C1779hy c1779hy, long j, long j2, String str) {
        this.f6692d = c1779hy;
        this.f6689a = j;
        this.f6690b = j2;
        this.f6691c = str;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (System.currentTimeMillis() - this.f6689a >= this.f6690b) {
            ((C1778hx) this.f6692d.f6682h.remove(this.f6691c)).m8797d();
            if (this.f6692d.f6682h.size() == 0) {
                new Handler(Looper.getMainLooper()).post(new RunnableC1784ic(this));
            }
        }
    }
}
