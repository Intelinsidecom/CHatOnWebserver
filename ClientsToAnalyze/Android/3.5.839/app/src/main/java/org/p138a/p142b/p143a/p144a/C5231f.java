package org.p138a.p142b.p143a.p144a;

import java.util.Iterator;

/* compiled from: UnboundedFifoByteBuffer.java */
/* renamed from: org.a.b.a.a.f */
/* loaded from: classes.dex */
class C5231f {

    /* renamed from: a */
    protected byte[] f19072a;

    /* renamed from: b */
    protected int f19073b;

    /* renamed from: c */
    protected int f19074c;

    public C5231f() {
        this(32);
    }

    public C5231f(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The size must be greater than 0");
        }
        this.f19072a = new byte[i + 1];
        this.f19073b = 0;
        this.f19074c = 0;
    }

    /* renamed from: a */
    public int m19934a() {
        if (this.f19074c < this.f19073b) {
            return (this.f19072a.length - this.f19073b) + this.f19074c;
        }
        return this.f19074c - this.f19073b;
    }

    /* renamed from: b */
    public boolean m19936b() {
        return m19934a() == 0;
    }

    /* renamed from: a */
    public boolean m19935a(byte b2) {
        if (m19934a() + 1 >= this.f19072a.length) {
            byte[] bArr = new byte[((this.f19072a.length - 1) * 2) + 1];
            int i = this.f19073b;
            int i2 = 0;
            while (i != this.f19074c) {
                bArr[i2] = this.f19072a[i];
                this.f19072a[i] = 0;
                i2++;
                i++;
                if (i == this.f19072a.length) {
                    i = 0;
                }
            }
            this.f19072a = bArr;
            this.f19073b = 0;
            this.f19074c = i2;
        }
        this.f19072a[this.f19074c] = b2;
        this.f19074c++;
        if (this.f19074c >= this.f19072a.length) {
            this.f19074c = 0;
            return true;
        }
        return true;
    }

    /* renamed from: c */
    public byte m19937c() {
        if (m19936b()) {
            throw new IllegalStateException("The buffer is already empty");
        }
        byte b2 = this.f19072a[this.f19073b];
        this.f19073b++;
        if (this.f19073b >= this.f19072a.length) {
            this.f19073b = 0;
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m19930a(int i) {
        int i2 = i + 1;
        if (i2 >= this.f19072a.length) {
            return 0;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m19932b(int i) {
        int i2 = i - 1;
        if (i2 < 0) {
            return this.f19072a.length - 1;
        }
        return i2;
    }

    /* renamed from: d */
    public Iterator<Byte> m19938d() {
        return new C5232g(this);
    }
}
