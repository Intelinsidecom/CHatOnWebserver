package com.sec.chaton.chat;

import java.util.TimerTask;

/* compiled from: TypingStateManager.java */
/* renamed from: com.sec.chaton.chat.hz */
/* loaded from: classes.dex */
class C1780hz extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C1779hy f6683a;

    C1780hz(C1779hy c1779hy) {
        this.f6683a = c1779hy;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f6683a.f6675a == EnumC1787if.ACTIVE) {
            this.f6683a.f6680f.m9641a(EnumC1787if.m8817a(this.f6683a.f6675a), 65);
        } else {
            this.f6683a.m8808e();
        }
    }
}
