package com.sec.chaton.p013a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: MessageControl2.java */
/* renamed from: com.sec.chaton.a.h */
/* loaded from: classes.dex */
class HandlerC0209h extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0223v f511a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0209h(C0223v c0223v, Looper looper) {
        super(looper);
        this.f511a = c0223v;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null) {
            int i = message.what;
        }
    }
}
