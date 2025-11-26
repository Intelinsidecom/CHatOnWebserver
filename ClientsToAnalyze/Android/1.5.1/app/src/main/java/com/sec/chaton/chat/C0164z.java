package com.sec.chaton.chat;

import android.os.Handler;
import java.util.TimerTask;

/* renamed from: com.sec.chaton.chat.z */
/* loaded from: classes.dex */
class C0164z extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ Handler f986a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f987b;

    C0164z(ChatFragment chatFragment, Handler handler) {
        this.f987b = chatFragment;
        this.f986a = handler;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f986a.post(new RunnableC0135a(this));
    }
}
