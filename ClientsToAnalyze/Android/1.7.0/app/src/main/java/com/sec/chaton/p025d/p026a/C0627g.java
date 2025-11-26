package com.sec.chaton.p025d.p026a;

import android.content.AsyncQueryHandler;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.p025d.p027b.AbstractC0647j;

/* compiled from: NotifyingAsyncTaskWorker.java */
/* renamed from: com.sec.chaton.d.a.g */
/* loaded from: classes.dex */
public class C0627g extends AsyncQueryHandler {

    /* renamed from: a */
    private Handler f2191a;

    /* renamed from: a */
    public static void m2858a(C0627g c0627g, int i, AbstractC0647j abstractC0647j) {
        c0627g.m2857a(i, abstractC0647j);
    }

    public C0627g() {
        super(null);
    }

    @Override // android.content.AsyncQueryHandler
    protected Handler createHandler(Looper looper) {
        this.f2191a = new C0628h(this, looper);
        return this.f2191a;
    }

    /* renamed from: a */
    private final void m2857a(int i, AbstractC0647j abstractC0647j) {
        Message message = new Message();
        message.what = i;
        message.obj = abstractC0647j;
        this.f2191a.sendMessage(message);
    }
}
