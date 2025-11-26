package com.sec.chaton.p067j;

import com.sec.common.C4996f;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: QueueManager.java */
/* renamed from: com.sec.chaton.j.w */
/* loaded from: classes.dex */
public class C2472w {

    /* renamed from: a */
    private static final String f8865a = C2472w.class.getSimpleName();

    /* renamed from: b */
    private static final C2472w f8866b = new C2472w();

    /* renamed from: c */
    private final ReentrantReadWriteLock f8867c = new ReentrantReadWriteLock();

    /* renamed from: d */
    private final Lock f8868d = this.f8867c.readLock();

    /* renamed from: e */
    private final Lock f8869e = this.f8867c.writeLock();

    /* renamed from: f */
    private C2461l f8870f;

    /* renamed from: g */
    private C2461l f8871g;

    /* renamed from: h */
    private C2461l f8872h;

    /* renamed from: i */
    private C2461l f8873i;

    /* renamed from: a */
    public static C2472w m10687a() {
        return f8866b;
    }

    private C2472w() {
        m10688g();
    }

    /* renamed from: b */
    public C2461l m10690b() {
        this.f8868d.lock();
        try {
            return this.f8870f;
        } finally {
            this.f8868d.unlock();
        }
    }

    /* renamed from: c */
    public C2461l m10691c() {
        this.f8868d.lock();
        try {
            return this.f8871g;
        } finally {
            this.f8868d.unlock();
        }
    }

    /* renamed from: d */
    public C2461l m10692d() {
        this.f8868d.lock();
        try {
            return this.f8872h;
        } finally {
            this.f8868d.unlock();
        }
    }

    /* renamed from: e */
    public C2461l m10693e() {
        this.f8868d.lock();
        try {
            return this.f8873i;
        } finally {
            this.f8868d.unlock();
        }
    }

    /* renamed from: f */
    public void m10694f() throws InterruptedException {
        this.f8869e.lockInterruptibly();
        try {
            m10689h();
            m10688g();
        } finally {
            this.f8869e.unlock();
        }
    }

    /* renamed from: g */
    private void m10688g() {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f8865a, "Start initialization all queue.");
        }
        this.f8870f = new C2461l("CoreQueue");
        this.f8871g = new C2461l("ServiceQueue");
        this.f8872h = new C2461l("MessageQueue");
        this.f8873i = new C2461l("QMLogQueue");
    }

    /* renamed from: h */
    private void m10689h() throws InterruptedException {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f8865a, "Start shutdown all queue.");
        }
        this.f8870f.m10665a();
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f8865a, " - Core queue is shutdown.");
        }
        this.f8871g.m10665a();
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f8865a, " - Service queue is shutdown.");
        }
        this.f8872h.m10665a();
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f8865a, " - Message queue is shutdown.");
        }
        this.f8873i.m10665a();
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f8865a, " - QMLog queue is shutdown.");
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f8865a, "All queue is shutdown.");
        }
    }
}
