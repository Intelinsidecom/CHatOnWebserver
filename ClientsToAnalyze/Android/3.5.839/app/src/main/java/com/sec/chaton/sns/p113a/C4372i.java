package com.sec.chaton.sns.p113a;

import java.util.TimerTask;

/* compiled from: SnsManager.java */
/* renamed from: com.sec.chaton.sns.a.i */
/* loaded from: classes.dex */
class C4372i extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC4371h f15844a;

    C4372i(AsyncTaskC4371h asyncTaskC4371h) {
        this.f15844a = asyncTaskC4371h;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f15844a.f15839a.m16572b("Time Out! \t- 30000ms");
        synchronized (this.f15844a.f15839a.f15833d) {
            this.f15844a.f15842d = true;
            this.f15844a.cancel(true);
        }
    }
}
