package com.sec.chaton.settings.tellfriends.common;

import java.util.TimerTask;

/* compiled from: SnsManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.common.r */
/* loaded from: classes.dex */
class C2802r extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC2801q f10312a;

    C2802r(AsyncTaskC2801q asyncTaskC2801q) {
        this.f10312a = asyncTaskC2801q;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f10312a.f10307a.m10015c("Time Out! \t- 30000ms");
        synchronized (this.f10312a.f10310d) {
            this.f10312a.f10310d = true;
            this.f10312a.cancel(true);
        }
    }
}
