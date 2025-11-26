package com.sec.chaton.msgsend;

/* compiled from: ElapsedTime.java */
/* renamed from: com.sec.chaton.msgsend.j */
/* loaded from: classes.dex */
public class C1750j {

    /* renamed from: a */
    public long f6447a;

    /* renamed from: b */
    public long f6448b;

    /* renamed from: c */
    public long f6449c;

    /* renamed from: d */
    public long f6450d;

    /* renamed from: e */
    public long f6451e;

    /* renamed from: f */
    public long f6452f;

    public C1750j(long j, long j2) {
        this(j - j2);
    }

    public C1750j(long j) {
        this.f6447a = j;
        this.f6452f = j % 1000;
        long j2 = j / 1000;
        this.f6451e = j2 % 60;
        long j3 = j2 / 60;
        this.f6450d = j3 % 60;
        long j4 = j3 / 60;
        this.f6449c = j4 % 24;
        this.f6448b = j4 / 24;
    }

    public String toString() {
        return String.format("(%d msec), %dday/%02d:%02d:%02d.%03d", Long.valueOf(this.f6447a), Long.valueOf(this.f6448b), Long.valueOf(this.f6449c), Long.valueOf(this.f6450d), Long.valueOf(this.f6451e), Long.valueOf(this.f6452f));
    }
}
