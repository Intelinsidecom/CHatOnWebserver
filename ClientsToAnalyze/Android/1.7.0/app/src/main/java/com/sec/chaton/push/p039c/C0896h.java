package com.sec.chaton.push.p039c;

import android.content.Context;
import android.os.SystemClock;
import com.sec.chaton.push.util.AlarmTimer;
import com.sec.chaton.push.util.C0921g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* compiled from: MessageTaskQueue.java */
/* renamed from: com.sec.chaton.push.c.h */
/* loaded from: classes.dex */
public final class C0896h {

    /* renamed from: a */
    private static final String f3065a = C0896h.class.getSimpleName();

    /* renamed from: b */
    private static C0896h f3066b;

    /* renamed from: c */
    private BlockingQueue f3067c = new PriorityBlockingQueue();

    /* renamed from: d */
    private List f3068d = new ArrayList();

    /* renamed from: a */
    public static synchronized C0896h m3520a() {
        if (f3066b == null) {
            f3066b = new C0896h();
        }
        return f3066b;
    }

    private C0896h() {
    }

    /* renamed from: a */
    public synchronized void m3527a(AbstractC0894f abstractC0894f) {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3065a, String.format("Put task to MessageTaskQueue. task: %s", abstractC0894f));
        }
        this.f3067c.put(abstractC0894f);
    }

    /* renamed from: b */
    public AbstractC0894f m3529b() {
        return (AbstractC0894f) this.f3067c.take();
    }

    /* renamed from: a */
    public synchronized void m3526a(Context context, String str, long j, AbstractC0894f abstractC0894f) {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3065a, String.format("Reserve delayed task (%d seconds).", Long.valueOf(j / 1000)));
        }
        this.f3068d.add(str);
        AlarmTimer.m3603a().m3606a(context, str, SystemClock.elapsedRealtime() + j, new C0897i(this, abstractC0894f, str));
    }

    /* renamed from: a */
    public synchronized void m3525a(Context context, String str) {
        if (C0921g.f3116a) {
            C0921g.m3637a(f3065a, "Cancel delayed task.");
        }
        this.f3068d.remove(str);
        AlarmTimer.m3603a().m3605a(context, str);
    }

    /* renamed from: a */
    public synchronized boolean m3528a(String str) {
        return this.f3068d.contains(str);
    }

    /* renamed from: a */
    public synchronized void m3524a(Context context, InterfaceC0892d interfaceC0892d) {
        synchronized (this) {
            for (Object obj : this.f3068d.toArray()) {
                m3525a(context, (String) obj);
            }
            Object[] array = this.f3067c.toArray();
            this.f3067c.clear();
            if (interfaceC0892d != null) {
                for (Object obj2 : array) {
                    if (obj2 != null) {
                        interfaceC0892d.mo3461a((AbstractC0894f) obj2);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public synchronized int m3530c() {
        return this.f3067c.size();
    }
}
