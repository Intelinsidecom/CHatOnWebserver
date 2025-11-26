package com.sec.chaton.p057e.p058a;

import android.content.AsyncQueryHandler;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p057e.p059b.AbstractC2240a;

/* compiled from: NotifyingAsyncTaskWorker.java */
/* renamed from: com.sec.chaton.e.a.z */
/* loaded from: classes.dex */
public class C2212z extends AsyncQueryHandler {

    /* renamed from: a */
    private Handler f7898a;

    /* renamed from: a */
    public static void m10068a(C2212z c2212z, int i, AbstractC2240a abstractC2240a) {
        c2212z.m10067a(i, abstractC2240a);
    }

    /* renamed from: a */
    public static C2212z m10066a() {
        return new C2212z();
    }

    public C2212z() {
        super(null);
    }

    @Override // android.content.AsyncQueryHandler
    protected Handler createHandler(Looper looper) {
        this.f7898a = new C2175aa(this, looper);
        return this.f7898a;
    }

    /* renamed from: a */
    private final void m10067a(int i, AbstractC2240a abstractC2240a) {
        Message message = new Message();
        message.what = i;
        message.obj = abstractC2240a;
        if (this.f7898a != null) {
            this.f7898a.sendMessage(message);
        }
    }
}
