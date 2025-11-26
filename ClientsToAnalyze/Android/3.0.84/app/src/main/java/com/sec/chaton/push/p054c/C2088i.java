package com.sec.chaton.push.p054c;

import android.content.Context;
import android.os.SystemClock;
import com.sec.chaton.push.util.AlarmTimer;
import com.sec.chaton.push.util.C2115g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* compiled from: MessageTaskQueue.java */
/* renamed from: com.sec.chaton.push.c.i */
/* loaded from: classes.dex */
public final class C2088i {

    /* renamed from: a */
    private static final String f7991a = C2088i.class.getSimpleName();

    /* renamed from: b */
    private static C2088i f7992b;

    /* renamed from: c */
    private BlockingQueue<AbstractC2072a> f7993c = new PriorityBlockingQueue();

    /* renamed from: d */
    private List<String> f7994d = new ArrayList();

    /* renamed from: a */
    public static synchronized C2088i m8241a() {
        if (f7992b == null) {
            f7992b = new C2088i();
        }
        return f7992b;
    }

    private C2088i() {
    }

    /* renamed from: a */
    public synchronized void m8248a(AbstractC2072a abstractC2072a) {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7991a, String.format("Put task to MessageTaskQueue. task: %s", abstractC2072a));
        }
        this.f7993c.put(abstractC2072a);
    }

    /* renamed from: b */
    public AbstractC2072a m8250b() {
        return this.f7993c.take();
    }

    /* renamed from: a */
    public synchronized void m8247a(Context context, String str, long j, AbstractC2072a abstractC2072a) {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7991a, String.format("Reserve delayed task (%d seconds).", Long.valueOf(j / 1000)));
        }
        this.f7994d.add(str);
        AlarmTimer.m8327a().m8330a(context, str, SystemClock.elapsedRealtime() + j, new C2089j(this, abstractC2072a, str));
    }

    /* renamed from: a */
    public synchronized void m8246a(Context context, String str) {
        if (C2115g.f8048a) {
            C2115g.m8359a(f7991a, "Cancel delayed task.");
        }
        this.f7994d.remove(str);
        AlarmTimer.m8327a().m8329a(context, str);
    }

    /* renamed from: a */
    public synchronized boolean m8249a(String str) {
        return this.f7994d.contains(str);
    }

    /* renamed from: a */
    public synchronized void m8245a(Context context, InterfaceC2090k interfaceC2090k) {
        synchronized (this) {
            for (Object obj : this.f7994d.toArray()) {
                m8246a(context, (String) obj);
            }
            Object[] array = this.f7993c.toArray();
            this.f7993c.clear();
            if (interfaceC2090k != null) {
                for (Object obj2 : array) {
                    if (obj2 != null) {
                        interfaceC2090k.mo8177a((AbstractC2072a) obj2);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public synchronized int m8251c() {
        return this.f7993c.size();
    }
}
