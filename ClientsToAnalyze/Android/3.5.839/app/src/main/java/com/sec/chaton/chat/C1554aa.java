package com.sec.chaton.chat;

import android.os.Handler;
import java.util.TimerTask;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.aa */
/* loaded from: classes.dex */
class C1554aa extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f5954a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f5955b;

    C1554aa(ChatFragment chatFragment, Handler handler) {
        this.f5955b = chatFragment;
        this.f5954a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f5954a.post(new RunnableC1555ab(this));
    }
}
