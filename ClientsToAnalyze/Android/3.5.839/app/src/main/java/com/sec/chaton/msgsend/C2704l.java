package com.sec.chaton.msgsend;

import android.os.SystemClock;

/* compiled from: ElapsedTime.java */
/* renamed from: com.sec.chaton.msgsend.l */
/* loaded from: classes.dex */
public class C2704l {

    /* renamed from: a */
    long f9688a;

    /* renamed from: b */
    long f9689b;

    /* renamed from: c */
    long f9690c;

    private C2704l() {
    }

    /* renamed from: a */
    public static C2704l m11322a() {
        return new C2704l();
    }

    /* renamed from: b */
    public C2704l m11323b() {
        this.f9688a = SystemClock.uptimeMillis();
        return this;
    }

    /* renamed from: c */
    public C2704l m11324c() {
        this.f9689b = SystemClock.uptimeMillis();
        this.f9690c = this.f9689b - this.f9688a;
        return this;
    }

    /* renamed from: d */
    public long m11325d() {
        m11324c();
        return this.f9690c;
    }

    public String toString() {
        return String.format("elapsed in %s", new C2705m(this.f9690c));
    }
}
