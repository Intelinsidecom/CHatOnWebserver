package com.sec.chaton.chat.background;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.util.C3250y;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* compiled from: ChatBackgroundHandler.java */
/* renamed from: com.sec.chaton.chat.background.a */
/* loaded from: classes.dex */
public class HandlerC0967a extends Handler {

    /* renamed from: a */
    private Map<Long, C0972f> f3967a;

    /* renamed from: b */
    private C0969c f3968b;

    public HandlerC0967a() {
        this.f3967a = new HashMap();
        this.f3968b = null;
        m5187b();
    }

    public HandlerC0967a(Looper looper) {
        super(looper);
        this.f3967a = new HashMap();
        this.f3968b = null;
        m5187b();
    }

    /* renamed from: a */
    public boolean m5188a() {
        this.f3967a.clear();
        this.f3968b.m5191c();
        return true;
    }

    /* renamed from: b */
    private void m5187b() {
        this.f3968b = new C0969c();
        this.f3968b.m5190b();
    }

    /* renamed from: a */
    private void m5186a(C0977k c0977k) {
        C0972f c0970d;
        if (C3250y.f11735c) {
            C3250y.m11453c("addRequestToJobList", "ChatBackgroundHandler");
        }
        if (c0977k == null) {
            if (C3250y.f11735c) {
                C3250y.m11453c("addRequestToJobList - request is null", "ChatBackgroundHandler");
                return;
            }
            return;
        }
        if (c0977k.m5238q() == 0) {
            c0970d = new C0972f(this, getLooper(), c0977k.m5237p(), c0977k.m5236o(), c0977k.m5238q());
        } else {
            c0970d = new C0970d(this, getLooper(), c0977k.m5237p(), c0977k.m5236o(), c0977k.m5238q());
        }
        long jM5203c = c0970d.m5203c();
        int iMo5194a = c0970d.mo5194a(c0977k);
        if (iMo5194a != 1) {
            c0970d.mo5198a(false, iMo5194a, c0977k.m5212h());
            return;
        }
        this.f3967a.put(Long.valueOf(jM5203c), c0970d);
        BlockingQueue<Runnable> blockingQueueM5189a = this.f3968b.m5189a();
        if (blockingQueueM5189a != null) {
            if (!blockingQueueM5189a.offer(new RunnableC0968b(this, jM5203c))) {
                c0970d.mo5198a(false, 8, c0977k.m5212h());
                this.f3967a.remove(Long.valueOf(jM5203c));
                return;
            }
            return;
        }
        c0970d.mo5198a(false, 7, c0977k.m5212h());
        this.f3967a.remove(Long.valueOf(jM5203c));
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                m5186a((C0977k) message.obj);
                break;
            case 1:
                this.f3967a.remove(Long.valueOf(((Long) message.obj).longValue())).m5202b();
                C3250y.m11453c("REQUEST_JOB_COMPLETED", "ChatBackgroundHandler");
                break;
        }
    }
}
