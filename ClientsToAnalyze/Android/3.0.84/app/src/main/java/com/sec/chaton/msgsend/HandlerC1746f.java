package com.sec.chaton.msgsend;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ChatONMessageService.java */
/* renamed from: com.sec.chaton.msgsend.f */
/* loaded from: classes.dex */
final class HandlerC1746f extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatONMessageService f6442a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1746f(ChatONMessageService chatONMessageService, Looper looper) {
        super(looper);
        this.f6442a = chatONMessageService;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Intent intent = (Intent) message.obj;
        int i = message.arg1;
        this.f6442a.m7132a(intent);
        this.f6442a.stopSelf(i);
        C1759s.m7260a(ChatONMessageService.f6413a, "toss intent and stop thread : startId(%d)", Integer.valueOf(i));
    }
}
