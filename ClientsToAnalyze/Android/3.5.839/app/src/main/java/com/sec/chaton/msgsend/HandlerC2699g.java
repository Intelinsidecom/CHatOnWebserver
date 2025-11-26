package com.sec.chaton.msgsend;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ChatONMessageService.java */
/* renamed from: com.sec.chaton.msgsend.g */
/* loaded from: classes.dex */
final class HandlerC2699g extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatONMessageService f9682a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2699g(ChatONMessageService chatONMessageService, Looper looper) {
        super(looper);
        this.f9682a = chatONMessageService;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Intent intent = (Intent) message.obj;
        int i = message.arg1;
        this.f9682a.m11249a(intent);
        this.f9682a.stopSelf(i);
        C2684ab.m11290a(ChatONMessageService.f9616a, "toss intent and stop thread : startId(%d)", Integer.valueOf(i));
    }
}
