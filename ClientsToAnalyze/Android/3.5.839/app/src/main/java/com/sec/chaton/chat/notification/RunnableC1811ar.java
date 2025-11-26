package com.sec.chaton.chat.notification;

import com.sec.chaton.util.C4904y;

/* compiled from: ScreenWebNotification.java */
/* renamed from: com.sec.chaton.chat.notification.ar */
/* loaded from: classes.dex */
class RunnableC1811ar implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ScreenWebNotification f6829a;

    RunnableC1811ar(ScreenWebNotification screenWebNotification) {
        this.f6829a = screenWebNotification;
    }

    @Override // java.lang.Runnable
    public void run() {
        C4904y.m18634a("Callback - close popup", this.f6829a.f6782n);
        this.f6829a.m8891f();
    }
}
