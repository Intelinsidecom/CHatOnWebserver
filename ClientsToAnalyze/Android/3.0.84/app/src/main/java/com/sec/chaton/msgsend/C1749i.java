package com.sec.chaton.msgsend;

import android.os.SystemClock;

/* compiled from: ElapsedTime.java */
/* renamed from: com.sec.chaton.msgsend.i */
/* loaded from: classes.dex */
public class C1749i {

    /* renamed from: a */
    long f6444a;

    /* renamed from: b */
    long f6445b;

    /* renamed from: c */
    long f6446c;

    private C1749i() {
    }

    /* renamed from: a */
    public static C1749i m7195a() {
        return new C1749i();
    }

    /* renamed from: b */
    public C1749i m7196b() {
        this.f6444a = SystemClock.uptimeMillis();
        return this;
    }

    /* renamed from: c */
    public C1749i m7197c() {
        this.f6445b = SystemClock.uptimeMillis();
        this.f6446c = this.f6445b - this.f6444a;
        return this;
    }

    public String toString() {
        return String.format("elapsed in %s", new C1750j(this.f6446c));
    }
}
