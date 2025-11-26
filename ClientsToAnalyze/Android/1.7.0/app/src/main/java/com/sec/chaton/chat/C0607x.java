package com.sec.chaton.chat;

import android.os.Handler;
import java.util.TimerTask;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.x */
/* loaded from: classes.dex */
class C0607x extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f2140a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f2141b;

    C0607x(ChatFragment chatFragment, Handler handler) {
        this.f2141b = chatFragment;
        this.f2140a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f2140a.post(new RunnableC0588e(this));
    }
}
