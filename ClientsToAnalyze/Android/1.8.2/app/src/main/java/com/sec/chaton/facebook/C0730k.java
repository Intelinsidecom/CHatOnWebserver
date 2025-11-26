package com.sec.chaton.facebook;

import java.util.TimerTask;

/* compiled from: FacebookManager.java */
/* renamed from: com.sec.chaton.facebook.k */
/* loaded from: classes.dex */
class C0730k extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC0729j f2717a;

    C0730k(AsyncTaskC0729j asyncTaskC0729j) {
        this.f2717a = asyncTaskC0729j;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        C0725f.m3214d("Time Out! \t- 30000ms");
        synchronized (this.f2717a.f2715d) {
            this.f2717a.f2715d = true;
            this.f2717a.cancel(true);
        }
    }
}
