package com.sec.chaton.p013a.p014a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: NetTaskHandler.java */
/* renamed from: com.sec.chaton.a.a.l */
/* loaded from: classes.dex */
public class HandlerC0173l extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0134aj f418a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0173l(C0134aj c0134aj, Looper looper) {
        super(looper);
        this.f418a = c0134aj;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        super.handleMessage(message);
        AbstractC0164c abstractC0164c = (AbstractC0164c) message.obj;
        abstractC0164c.m701a(abstractC0164c);
    }
}
