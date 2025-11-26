package com.sec.chaton.chat;

import android.os.Handler;
import java.util.TimerTask;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.m */
/* loaded from: classes.dex */
class C1101m extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f4364a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f4365b;

    C1101m(ChatFragment chatFragment, Handler handler) {
        this.f4365b = chatFragment;
        this.f4364a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f4364a.post(new RunnableC1102n(this));
    }
}
