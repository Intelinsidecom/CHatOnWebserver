package com.sec.chaton.chat.notification;

import com.sec.chaton.util.C3250y;

/* compiled from: ScreenWebNotification.java */
/* renamed from: com.sec.chaton.chat.notification.aa */
/* loaded from: classes.dex */
class RunnableC1104aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ScreenWebNotification f4476a;

    RunnableC1104aa(ScreenWebNotification screenWebNotification) {
        this.f4476a = screenWebNotification;
    }

    @Override // java.lang.Runnable
    public void run() {
        C3250y.m11442a("Callback - close popup", this.f4476a.f4426a);
        this.f4476a.m5430a();
    }
}
