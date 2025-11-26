package com.sec.chaton.p055d.p056a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: NetTaskHandler.java */
/* renamed from: com.sec.chaton.d.a.dv */
/* loaded from: classes.dex */
public class HandlerC2003dv extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2002du f7364a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2003dv(C2002du c2002du, Looper looper) {
        super(looper);
        this.f7364a = c2002du;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        super.handleMessage(message);
        AbstractC1927b abstractC1927b = (AbstractC1927b) message.obj;
        if (abstractC1927b != null) {
            abstractC1927b.m9102a(abstractC1927b);
        }
    }
}
