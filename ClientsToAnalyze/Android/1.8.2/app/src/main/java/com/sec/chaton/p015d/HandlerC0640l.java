package com.sec.chaton.p015d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: MessageControl.java */
/* renamed from: com.sec.chaton.d.l */
/* loaded from: classes.dex */
class HandlerC0640l extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0639k f2504a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0640l(C0639k c0639k, Looper looper) {
        super(looper);
        this.f2504a = c0639k;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null) {
            int i = message.what;
        }
    }
}
