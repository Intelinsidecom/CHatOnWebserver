package com.sec.chaton.chat.notification;

import com.sec.chaton.util.C3250y;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.n */
/* loaded from: classes.dex */
class RunnableC1118n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f4528a;

    RunnableC1118n(ScreenNotification2 screenNotification2) {
        this.f4528a = screenNotification2;
    }

    @Override // java.lang.Runnable
    public void run() {
        C3250y.m11442a("Callback - remove dialog", ScreenNotification2.f4381d);
        this.f4528a.m5424b();
    }
}
