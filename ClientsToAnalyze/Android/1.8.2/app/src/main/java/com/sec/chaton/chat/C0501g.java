package com.sec.chaton.chat;

import android.os.Handler;
import java.util.TimerTask;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.g */
/* loaded from: classes.dex */
class C0501g extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f2097a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f2098b;

    C0501g(ChatFragment chatFragment, Handler handler) {
        this.f2098b = chatFragment;
        this.f2097a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f2097a.post(new RunnableC0502h(this));
    }
}
