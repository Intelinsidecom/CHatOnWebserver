package com.sec.chaton.p015d.p016a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: NetTaskHandler.java */
/* renamed from: com.sec.chaton.d.a.bk */
/* loaded from: classes.dex */
public class HandlerC0570bk extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0569bj f2286a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0570bk(C0569bj c0569bj, Looper looper) {
        super(looper);
        this.f2286a = c0569bj;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        AbstractC0559b abstractC0559b = (AbstractC0559b) message.obj;
        abstractC0559b.m2756a(abstractC0559b);
    }
}
