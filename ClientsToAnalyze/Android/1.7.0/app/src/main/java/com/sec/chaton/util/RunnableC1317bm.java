package com.sec.chaton.util;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bm */
/* loaded from: classes.dex */
class RunnableC1317bm implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f4536a;

    RunnableC1317bm(ScreenOnNotification screenOnNotification) {
        this.f4536a = screenOnNotification;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4536a.removeDialog(1);
        this.f4536a.finish();
    }
}
