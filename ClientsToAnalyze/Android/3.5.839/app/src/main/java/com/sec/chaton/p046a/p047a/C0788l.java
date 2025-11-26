package com.sec.chaton.p046a.p047a;

/* compiled from: MessageResultEntry.java */
/* renamed from: com.sec.chaton.a.a.l */
/* loaded from: classes.dex */
public class C0788l extends C0790n {

    /* renamed from: d */
    private int f2153d;

    /* renamed from: e */
    private long f2154e;

    /* renamed from: f */
    private int f2155f;

    public C0788l(boolean z, int i) {
        super(z);
        this.f2155f = -1;
        this.f2153d = i;
        this.f2173b = EnumC0791o.SUCCESS;
        this.f2154e = -1L;
    }

    public C0788l(boolean z, int i, long j) {
        super(z);
        this.f2155f = -1;
        this.f2153d = i;
        this.f2173b = EnumC0791o.SUCCESS;
        this.f2154e = j;
    }

    public C0788l(boolean z, int i, long j, int i2) {
        this(z, i, j);
        this.f2155f = i2;
    }

    public C0788l(boolean z, int i, String str) {
        super(z, str);
        this.f2155f = -1;
        this.f2153d = i;
        this.f2173b = EnumC0791o.SUCCESS;
        this.f2154e = -1L;
    }

    public C0788l(boolean z, int i, String str, long j) {
        super(z, str);
        this.f2155f = -1;
        this.f2153d = i;
        this.f2173b = EnumC0791o.SUCCESS;
        this.f2154e = j;
    }

    public C0788l(boolean z, EnumC0791o enumC0791o) {
        super(z, enumC0791o);
        this.f2155f = -1;
        this.f2153d = -1;
        this.f2154e = -1L;
    }

    /* renamed from: g */
    public int m3152g() {
        return this.f2153d;
    }

    /* renamed from: h */
    public long m3153h() {
        return this.f2154e;
    }

    /* renamed from: i */
    public int m3154i() {
        return this.f2155f;
    }
}
