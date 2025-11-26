package com.sec.chaton.chat.notification;

import com.sec.chaton.util.C4904y;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.ae */
/* loaded from: classes.dex */
class RunnableC1798ae implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f6808a;

    RunnableC1798ae(ScreenNotification2 screenNotification2) {
        this.f6808a = screenNotification2;
    }

    @Override // java.lang.Runnable
    public void run() {
        C4904y.m18634a("Callback - remove dialog", ScreenNotification2.f6727v);
        this.f6808a.m8882g();
    }
}
