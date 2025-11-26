package com.sec.chaton.p037j;

import com.sec.common.C3330f;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: QueueManager.java */
/* renamed from: com.sec.chaton.j.w */
/* loaded from: classes.dex */
public class C1595w {

    /* renamed from: a */
    private static final String f5917a = C1595w.class.getSimpleName();

    /* renamed from: b */
    private static C1595w f5918b;

    /* renamed from: c */
    private final ReentrantReadWriteLock f5919c = new ReentrantReadWriteLock();

    /* renamed from: d */
    private final Lock f5920d = this.f5919c.readLock();

    /* renamed from: e */
    private final Lock f5921e = this.f5919c.writeLock();

    /* renamed from: f */
    private C1584l f5922f;

    /* renamed from: g */
    private C1584l f5923g;

    /* renamed from: h */
    private C1584l f5924h;

    /* renamed from: a */
    public static C1595w m6742a() {
        if (f5918b == null) {
            synchronized (C1595w.class) {
                if (f5918b == null) {
                    f5918b = new C1595w();
                }
            }
        }
        return f5918b;
    }

    private C1595w() {
        m6743f();
    }

    /* renamed from: b */
    public C1584l m6745b() {
        this.f5920d.lock();
        try {
            return this.f5922f;
        } finally {
            this.f5920d.unlock();
        }
    }

    /* renamed from: c */
    public C1584l m6746c() {
        this.f5920d.lock();
        try {
            return this.f5923g;
        } finally {
            this.f5920d.unlock();
        }
    }

    /* renamed from: d */
    public C1584l m6747d() {
        this.f5920d.lock();
        try {
            return this.f5924h;
        } finally {
            this.f5920d.unlock();
        }
    }

    /* renamed from: e */
    public void m6748e() {
        this.f5921e.lockInterruptibly();
        try {
            m6744g();
            m6743f();
        } finally {
            this.f5921e.unlock();
        }
    }

    /* renamed from: f */
    private void m6743f() {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f5917a, "Start initialization all queue.");
        }
        this.f5922f = new C1584l("CoreQueue");
        this.f5923g = new C1584l("ServiceQueue");
        this.f5924h = new C1584l("MessageQueue");
    }

    /* renamed from: g */
    private void m6744g() throws InterruptedException {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f5917a, "Start shutdown all queue.");
        }
        this.f5922f.m6721a();
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f5917a, " - Core queue is shutdown.");
        }
        this.f5923g.m6721a();
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f5917a, " - Service queue is shutdown.");
        }
        this.f5924h.m6721a();
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f5917a, " - Message queue is shutdown.");
        }
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f5917a, "All queue is shutdown.");
        }
    }
}
