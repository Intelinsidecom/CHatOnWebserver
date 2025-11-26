package com.sec.chaton.p025d.p026a;

import android.content.AsyncQueryHandler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p025d.p027b.AbstractC0647j;

/* compiled from: NotifyingAsyncTaskWorker.java */
/* renamed from: com.sec.chaton.d.a.h */
/* loaded from: classes.dex */
public class C0628h extends AsyncQueryHandler.WorkerHandler {

    /* renamed from: a */
    final /* synthetic */ C0627g f2192a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0628h(C0627g c0627g, Looper looper) {
        super(c0627g, looper);
        this.f2192a = c0627g;
    }

    @Override // android.content.AsyncQueryHandler.WorkerHandler, android.os.Handler
    public void handleMessage(Message message) {
        ((AbstractC0647j) message.obj).m2973a(message.what);
    }
}
