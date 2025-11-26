package com.sec.chaton.p017e.p018a;

import android.content.AsyncQueryHandler;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p017e.p019b.AbstractC0674a;

/* compiled from: NotifyingAsyncTaskWorker.java */
/* renamed from: com.sec.chaton.e.a.l */
/* loaded from: classes.dex */
public class C0668l extends AsyncQueryHandler {

    /* renamed from: a */
    private Handler f2556a;

    /* renamed from: a */
    public static void m3077a(C0668l c0668l, int i, AbstractC0674a abstractC0674a) {
        c0668l.m3076a(i, abstractC0674a);
    }

    public C0668l() {
        super(null);
    }

    @Override // android.content.AsyncQueryHandler
    protected Handler createHandler(Looper looper) {
        this.f2556a = new C0669m(this, looper);
        return this.f2556a;
    }

    /* renamed from: a */
    private final void m3076a(int i, AbstractC0674a abstractC0674a) {
        Message message = new Message();
        message.what = i;
        message.obj = abstractC0674a;
        this.f2556a.sendMessage(message);
    }
}
