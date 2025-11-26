package com.sec.chaton.p015d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: TaskContainer.java */
/* renamed from: com.sec.chaton.d.ao */
/* loaded from: classes.dex */
class HandlerC0625ao extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0623am f2450a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0625ao(C0623am c0623am, Looper looper) {
        super(looper);
        this.f2450a = c0623am;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0626ap c0626ap = (C0626ap) this.f2450a.f2442a.get(this.f2450a.f2445d);
        if (this.f2450a.f2444c != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = message.what;
            messageObtain.obj = new C0628ar(this.f2450a.f2447f, c0626ap.m2826a(), message.obj);
            this.f2450a.f2444c.sendMessage(messageObtain);
        }
    }
}
