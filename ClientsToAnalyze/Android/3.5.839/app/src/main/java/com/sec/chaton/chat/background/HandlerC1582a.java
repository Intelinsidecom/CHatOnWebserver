package com.sec.chaton.chat.background;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.util.C4904y;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* compiled from: ChatBackgroundHandler.java */
/* renamed from: com.sec.chaton.chat.background.a */
/* loaded from: classes.dex */
public class HandlerC1582a extends Handler {

    /* renamed from: a */
    private Map<Long, C1587f> f6020a;

    /* renamed from: b */
    private C1584c f6021b;

    public HandlerC1582a() {
        this.f6020a = new HashMap();
        this.f6021b = null;
        m8438b();
    }

    public HandlerC1582a(Looper looper) {
        super(looper);
        this.f6020a = new HashMap();
        this.f6021b = null;
        m8438b();
    }

    /* renamed from: a */
    public boolean m8439a() {
        this.f6020a.clear();
        this.f6021b.m8442c();
        return true;
    }

    /* renamed from: b */
    private void m8438b() {
        this.f6021b = new C1584c();
        this.f6021b.m8441b();
    }

    /* renamed from: a */
    private void m8437a(C1592k c1592k) {
        C1587f c1585d;
        if (C4904y.f17873c) {
            C4904y.m18641c("addRequestToJobList", "ChatBackgroundHandler");
        }
        if (c1592k == null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("addRequestToJobList - request is null", "ChatBackgroundHandler");
                return;
            }
            return;
        }
        if (c1592k.m8491r() == 0) {
            c1585d = new C1587f(this, getLooper(), c1592k.m8490q(), c1592k.m8489p(), c1592k.m8491r());
        } else {
            c1585d = new C1585d(this, getLooper(), c1592k.m8490q(), c1592k.m8489p(), c1592k.m8491r());
        }
        long jM8454c = c1585d.m8454c();
        int iMo8445a = c1585d.mo8445a(c1592k);
        if (iMo8445a != 1) {
            c1585d.mo8449a(false, iMo8445a, c1592k.m8464i());
            return;
        }
        this.f6020a.put(Long.valueOf(jM8454c), c1585d);
        BlockingQueue<Runnable> blockingQueueM8440a = this.f6021b.m8440a();
        if (blockingQueueM8440a != null) {
            if (!blockingQueueM8440a.offer(new RunnableC1583b(this, jM8454c))) {
                c1585d.mo8449a(false, 8, c1592k.m8464i());
                this.f6020a.remove(Long.valueOf(jM8454c));
                return;
            }
            return;
        }
        c1585d.mo8449a(false, 7, c1592k.m8464i());
        this.f6020a.remove(Long.valueOf(jM8454c));
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                m8437a((C1592k) message.obj);
                break;
            case 1:
                C1587f c1587fRemove = this.f6020a.remove(Long.valueOf(((Long) message.obj).longValue()));
                if (c1587fRemove != null) {
                    c1587fRemove.m8453b();
                }
                C4904y.m18641c("REQUEST_JOB_COMPLETED", "ChatBackgroundHandler");
                break;
        }
    }
}
