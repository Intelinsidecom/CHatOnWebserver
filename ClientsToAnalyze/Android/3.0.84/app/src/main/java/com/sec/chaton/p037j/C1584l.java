package com.sec.chaton.p037j;

import com.sec.chaton.p025d.p026a.AbstractC1145a;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3364o;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: HttpNetworkQueue.java */
/* renamed from: com.sec.chaton.j.l */
/* loaded from: classes.dex */
public class C1584l {

    /* renamed from: a */
    private static final String f5890a = C1584l.class.getSimpleName();

    /* renamed from: b */
    private String f5891b;

    /* renamed from: c */
    private ThreadPoolExecutor f5892c;

    /* renamed from: d */
    private BlockingQueue<Runnable> f5893d;

    public C1584l(String str) {
        this(str, 1, 1);
    }

    public C1584l(String str, int i, int i2) {
        this.f5892c = null;
        this.f5893d = null;
        this.f5891b = str;
        this.f5893d = new PriorityBlockingQueue();
        this.f5892c = new ThreadPoolExecutor(i, i2, 0L, TimeUnit.MILLISECONDS, this.f5893d);
        this.f5892c.prestartAllCoreThreads();
    }

    /* renamed from: a */
    public void m6723a(AbstractC1145a abstractC1145a) {
        if (C3250y.f11734b) {
            C3250y.m11450b(C3364o.m11849a("Task is reserved. Task: ", abstractC1145a, ", Queue(name: ", this.f5891b, ", size: ", Integer.valueOf(this.f5893d.size()), ")"), f5890a);
        }
        C1585m c1585m = new C1585m(this, abstractC1145a, abstractC1145a);
        abstractC1145a.m5490a(c1585m);
        this.f5892c.execute(c1585m);
    }

    /* renamed from: a */
    public void m6721a() throws InterruptedException {
        m6722a(60000);
    }

    /* renamed from: a */
    public void m6722a(int i) throws InterruptedException {
        try {
            this.f5892c.shutdown();
            this.f5892c.shutdownNow();
            this.f5892c.awaitTermination(i, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }
    }
}
