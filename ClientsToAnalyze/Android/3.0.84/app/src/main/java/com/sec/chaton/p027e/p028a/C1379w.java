package com.sec.chaton.p027e.p028a;

import android.content.AsyncQueryHandler;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p027e.p029b.AbstractC1410a;

/* compiled from: NotifyingAsyncTaskWorker.java */
/* renamed from: com.sec.chaton.e.a.w */
/* loaded from: classes.dex */
public class C1379w extends AsyncQueryHandler {

    /* renamed from: a */
    private Handler f5163a;

    /* renamed from: a */
    public static void m6203a(C1379w c1379w, int i, AbstractC1410a abstractC1410a) {
        c1379w.m6202a(i, abstractC1410a);
    }

    public C1379w() {
        super(null);
    }

    @Override // android.content.AsyncQueryHandler
    protected Handler createHandler(Looper looper) {
        this.f5163a = new C1380x(this, looper);
        return this.f5163a;
    }

    /* renamed from: a */
    private final void m6202a(int i, AbstractC1410a abstractC1410a) {
        Message message = new Message();
        message.what = i;
        message.obj = abstractC1410a;
        if (this.f5163a != null) {
            this.f5163a.sendMessage(message);
        }
    }
}
