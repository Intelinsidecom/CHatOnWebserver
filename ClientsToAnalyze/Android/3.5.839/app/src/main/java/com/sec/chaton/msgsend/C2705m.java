package com.sec.chaton.msgsend;

/* compiled from: ElapsedTime.java */
/* renamed from: com.sec.chaton.msgsend.m */
/* loaded from: classes.dex */
public class C2705m {

    /* renamed from: a */
    public long f9691a;

    /* renamed from: b */
    public long f9692b;

    /* renamed from: c */
    public long f9693c;

    /* renamed from: d */
    public long f9694d;

    /* renamed from: e */
    public long f9695e;

    /* renamed from: f */
    public long f9696f;

    public C2705m(long j, long j2) {
        this(j - j2);
    }

    public C2705m(long j) {
        this.f9691a = j;
        this.f9696f = j % 1000;
        long j2 = j / 1000;
        this.f9695e = j2 % 60;
        long j3 = j2 / 60;
        this.f9694d = j3 % 60;
        long j4 = j3 / 60;
        this.f9693c = j4 % 24;
        this.f9692b = j4 / 24;
    }

    public String toString() {
        return String.format("(%d msec), %dday/%02d:%02d:%02d.%03d", Long.valueOf(this.f9691a), Long.valueOf(this.f9692b), Long.valueOf(this.f9693c), Long.valueOf(this.f9694d), Long.valueOf(this.f9695e), Long.valueOf(this.f9696f));
    }
}
