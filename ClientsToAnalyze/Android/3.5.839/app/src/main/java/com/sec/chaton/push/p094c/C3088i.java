package com.sec.chaton.push.p094c;

import android.content.Context;
import android.os.SystemClock;
import com.sec.chaton.push.util.AlarmTimer;
import com.sec.chaton.push.util.C3115g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* compiled from: MessageTaskQueue.java */
/* renamed from: com.sec.chaton.push.c.i */
/* loaded from: classes.dex */
public final class C3088i {

    /* renamed from: a */
    private static final String f11401a = C3088i.class.getSimpleName();

    /* renamed from: b */
    private static C3088i f11402b;

    /* renamed from: c */
    private BlockingQueue<AbstractC3072a> f11403c = new PriorityBlockingQueue();

    /* renamed from: d */
    private List<String> f11404d = new ArrayList();

    /* renamed from: a */
    public static synchronized C3088i m12584a() {
        if (f11402b == null) {
            f11402b = new C3088i();
        }
        return f11402b;
    }

    private C3088i() {
    }

    /* renamed from: a */
    public synchronized void m12591a(AbstractC3072a abstractC3072a) {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11401a, String.format("Put task to MessageTaskQueue. task: %s", abstractC3072a));
        }
        this.f11403c.put(abstractC3072a);
    }

    /* renamed from: b */
    public AbstractC3072a m12593b() {
        return this.f11403c.take();
    }

    /* renamed from: a */
    public synchronized void m12590a(Context context, String str, long j, AbstractC3072a abstractC3072a) {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11401a, String.format("Reserve delayed task (%d seconds).", Long.valueOf(j / 1000)));
        }
        this.f11404d.add(str);
        AlarmTimer.m12669a().m12672a(context, str, SystemClock.elapsedRealtime() + j, new C3089j(this, abstractC3072a, str));
    }

    /* renamed from: a */
    public synchronized void m12589a(Context context, String str) {
        if (C3115g.f11458a) {
            C3115g.m12701a(f11401a, "Cancel delayed task.");
        }
        this.f11404d.remove(str);
        AlarmTimer.m12669a().m12671a(context, str);
    }

    /* renamed from: a */
    public synchronized boolean m12592a(String str) {
        return this.f11404d.contains(str);
    }

    /* renamed from: a */
    public synchronized void m12588a(Context context, InterfaceC3090k interfaceC3090k) {
        synchronized (this) {
            for (Object obj : this.f11404d.toArray()) {
                m12589a(context, (String) obj);
            }
            Object[] array = this.f11403c.toArray();
            this.f11403c.clear();
            if (interfaceC3090k != null) {
                for (Object obj2 : array) {
                    if (obj2 != null) {
                        interfaceC3090k.mo12520a((AbstractC3072a) obj2);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public synchronized int m12594c() {
        return this.f11403c.size();
    }
}
