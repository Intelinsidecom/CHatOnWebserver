package com.sec.chaton.p013a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: TaskContainer.java */
/* renamed from: com.sec.chaton.a.m */
/* loaded from: classes.dex */
class HandlerC0214m extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0215n f520a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0214m(C0215n c0215n, Looper looper) {
        super(looper);
        this.f520a = c0215n;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C0199al c0199al = (C0199al) this.f520a.f521a.get(this.f520a.f524d);
        if (this.f520a.f523c != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = message.what;
            messageObtain.obj = new C0200am(this.f520a.f526f, c0199al.m749a(), message.obj);
            this.f520a.f523c.sendMessage(messageObtain);
        }
    }
}
