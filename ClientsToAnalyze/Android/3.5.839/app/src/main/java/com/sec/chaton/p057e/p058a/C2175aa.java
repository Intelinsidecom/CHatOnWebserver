package com.sec.chaton.p057e.p058a;

import android.content.AsyncQueryHandler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p057e.p059b.AbstractC2240a;

/* compiled from: NotifyingAsyncTaskWorker.java */
/* renamed from: com.sec.chaton.e.a.aa */
/* loaded from: classes.dex */
public class C2175aa extends AsyncQueryHandler.WorkerHandler {

    /* renamed from: a */
    final /* synthetic */ C2212z f7804a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2175aa(C2212z c2212z, Looper looper) {
        super(c2212z, looper);
        this.f7804a = c2212z;
    }

    @Override // android.content.AsyncQueryHandler.WorkerHandler, android.os.Handler
    public void handleMessage(Message message) {
        ((AbstractC2240a) message.obj).m10102a(message.what);
    }
}
