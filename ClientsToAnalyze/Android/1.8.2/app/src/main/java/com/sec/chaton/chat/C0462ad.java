package com.sec.chaton.chat;

import android.os.Handler;
import java.util.TimerTask;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ad */
/* loaded from: classes.dex */
class C0462ad extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f1928a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f1929b;

    C0462ad(ChatFragment chatFragment, Handler handler) {
        this.f1929b = chatFragment;
        this.f1928a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f1928a.post(new RunnableC0463ae(this));
    }
}
