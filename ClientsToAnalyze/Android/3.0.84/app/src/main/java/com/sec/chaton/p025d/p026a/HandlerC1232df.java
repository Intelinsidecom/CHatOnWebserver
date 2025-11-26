package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: NetTaskHandler.java */
/* renamed from: com.sec.chaton.d.a.df */
/* loaded from: classes.dex */
public class HandlerC1232df extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1231de f4774a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1232df(C1231de c1231de, Looper looper) {
        super(looper);
        this.f4774a = c1231de;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        super.handleMessage(message);
        AbstractC1199c abstractC1199c = (AbstractC1199c) message.obj;
        abstractC1199c.m5539a(abstractC1199c);
    }
}
