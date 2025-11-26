package com.sec.chaton.push.p044c;

import android.content.Context;
import android.os.SystemClock;
import com.sec.chaton.push.util.AlarmTimer;
import com.sec.chaton.push.util.C1139g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* compiled from: MessageTaskQueue.java */
/* renamed from: com.sec.chaton.push.c.i */
/* loaded from: classes.dex */
public final class C1115i {

    /* renamed from: a */
    private static final String f4087a = C1115i.class.getSimpleName();

    /* renamed from: b */
    private static C1115i f4088b;

    /* renamed from: c */
    private BlockingQueue f4089c = new PriorityBlockingQueue();

    /* renamed from: d */
    private List f4090d = new ArrayList();

    /* renamed from: a */
    public static synchronized C1115i m4196a() {
        if (f4088b == null) {
            f4088b = new C1115i();
        }
        return f4088b;
    }

    private C1115i() {
    }

    /* renamed from: a */
    public synchronized void m4203a(AbstractC1099a abstractC1099a) {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4087a, String.format("Put task to MessageTaskQueue. task: %s", abstractC1099a));
        }
        this.f4089c.put(abstractC1099a);
    }

    /* renamed from: b */
    public AbstractC1099a m4205b() {
        return (AbstractC1099a) this.f4089c.take();
    }

    /* renamed from: a */
    public synchronized void m4202a(Context context, String str, long j, AbstractC1099a abstractC1099a) {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4087a, String.format("Reserve delayed task (%d seconds).", Long.valueOf(j / 1000)));
        }
        this.f4090d.add(str);
        AlarmTimer.m4276a().m4279a(context, str, SystemClock.elapsedRealtime() + j, new C1116j(this, abstractC1099a, str));
    }

    /* renamed from: a */
    public synchronized void m4201a(Context context, String str) {
        if (C1139g.f4142a) {
            C1139g.m4308a(f4087a, "Cancel delayed task.");
        }
        this.f4090d.remove(str);
        AlarmTimer.m4276a().m4278a(context, str);
    }

    /* renamed from: a */
    public synchronized boolean m4204a(String str) {
        return this.f4090d.contains(str);
    }

    /* renamed from: a */
    public synchronized void m4200a(Context context, InterfaceC1117k interfaceC1117k) {
        synchronized (this) {
            for (Object obj : this.f4090d.toArray()) {
                m4201a(context, (String) obj);
            }
            Object[] array = this.f4089c.toArray();
            this.f4089c.clear();
            if (interfaceC1117k != null) {
                for (Object obj2 : array) {
                    if (obj2 != null) {
                        interfaceC1117k.mo4133a((AbstractC1099a) obj2);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public synchronized int m4206c() {
        return this.f4089c.size();
    }
}
