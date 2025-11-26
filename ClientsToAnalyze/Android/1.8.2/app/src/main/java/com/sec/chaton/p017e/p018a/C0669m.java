package com.sec.chaton.p017e.p018a;

import android.content.AsyncQueryHandler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p017e.p019b.AbstractC0674a;

/* compiled from: NotifyingAsyncTaskWorker.java */
/* renamed from: com.sec.chaton.e.a.m */
/* loaded from: classes.dex */
public class C0669m extends AsyncQueryHandler.WorkerHandler {

    /* renamed from: a */
    final /* synthetic */ C0668l f2557a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0669m(C0668l c0668l, Looper looper) {
        super(c0668l, looper);
        this.f2557a = c0668l;
    }

    @Override // android.content.AsyncQueryHandler.WorkerHandler, android.os.Handler
    public void handleMessage(Message message) {
        ((AbstractC0674a) message.obj).m3099a(message.what);
    }
}
