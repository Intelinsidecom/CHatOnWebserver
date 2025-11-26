package com.sec.chaton.util;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bi */
/* loaded from: classes.dex */
class RunnableC1753bi implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f6391a;

    RunnableC1753bi(ScreenOnNotification screenOnNotification) {
        this.f6391a = screenOnNotification;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6391a.removeDialog(1);
        this.f6391a.finish();
    }
}
