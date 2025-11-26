package com.sec.chaton.p055d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: LiveChatMessageControl.java */
/* renamed from: com.sec.chaton.d.r */
/* loaded from: classes.dex */
class HandlerC2137r extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2136q f7744a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2137r(C2136q c2136q, Looper looper) {
        super(looper);
        this.f7744a = c2136q;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f7744a.m9242a(message.arg1, message.arg2, message.what, message.obj, -1L);
    }
}
