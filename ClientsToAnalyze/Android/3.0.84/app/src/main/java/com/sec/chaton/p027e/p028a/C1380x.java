package com.sec.chaton.p027e.p028a;

import android.content.AsyncQueryHandler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p027e.p029b.AbstractC1410a;

/* compiled from: NotifyingAsyncTaskWorker.java */
/* renamed from: com.sec.chaton.e.a.x */
/* loaded from: classes.dex */
public class C1380x extends AsyncQueryHandler.WorkerHandler {

    /* renamed from: a */
    final /* synthetic */ C1379w f5164a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1380x(C1379w c1379w, Looper looper) {
        super(c1379w, looper);
        this.f5164a = c1379w;
    }

    @Override // android.content.AsyncQueryHandler.WorkerHandler, android.os.Handler
    public void handleMessage(Message message) {
        ((AbstractC1410a) message.obj).m6264a(message.what);
    }
}
