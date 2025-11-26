package com.samsung.sdraw;

import java.util.Random;

/* renamed from: com.samsung.sdraw.ah */
/* loaded from: classes.dex */
class C0995ah {

    /* renamed from: a */
    protected long[] f1443a;

    /* renamed from: b */
    protected int f1444b;

    public C0995ah() {
        this(1234567890L);
    }

    public C0995ah(long j) {
        this.f1443a = new long[16];
        this.f1444b = 0;
        Random random = new Random();
        random.setSeed(j);
        for (int i = 0; i < this.f1443a.length; i++) {
            this.f1443a[i] = random.nextLong();
        }
    }

    /* renamed from: a */
    public long m1278a() {
        long j = this.f1443a[this.f1444b];
        long j2 = this.f1443a[(this.f1444b + 13) & 15];
        long j3 = ((j << 16) ^ (j ^ j2)) ^ (j2 << 15);
        long j4 = this.f1443a[(this.f1444b + 9) & 15];
        long j5 = j4 ^ (j4 >> 11);
        long j6 = j3 ^ j5;
        this.f1443a[this.f1444b] = j6;
        long j7 = ((j6 << 5) & (-633066208)) ^ j6;
        this.f1444b = (this.f1444b + 15) & 15;
        long j8 = this.f1443a[this.f1444b];
        this.f1443a[this.f1444b] = ((j3 << 18) ^ ((j7 ^ (j8 ^ j3)) ^ (j8 << 2))) ^ (j5 << 28);
        return this.f1443a[this.f1444b];
    }

    /* renamed from: b */
    public float m1279b() {
        return m1278a() / 9.223372E18f;
    }
}
