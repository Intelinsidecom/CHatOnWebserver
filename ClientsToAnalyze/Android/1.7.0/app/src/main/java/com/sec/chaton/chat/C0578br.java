package com.sec.chaton.chat;

import android.os.Handler;
import java.util.TimerTask;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.br */
/* loaded from: classes.dex */
class C0578br extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f1995a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f1996b;

    C0578br(ChatFragment chatFragment, Handler handler) {
        this.f1996b = chatFragment;
        this.f1995a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f1995a.post(new RunnableC0541aq(this));
    }
}
