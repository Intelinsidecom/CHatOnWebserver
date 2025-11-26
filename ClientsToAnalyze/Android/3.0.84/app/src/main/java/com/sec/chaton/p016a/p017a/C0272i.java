package com.sec.chaton.p016a.p017a;

/* compiled from: MessageResultEntry.java */
/* renamed from: com.sec.chaton.a.a.i */
/* loaded from: classes.dex */
public class C0272i extends C0274k {

    /* renamed from: d */
    private int f841d;

    /* renamed from: e */
    private long f842e;

    public C0272i(boolean z, int i) {
        super(z);
        this.f841d = i;
        this.f859b = EnumC0275l.SUCCESS;
        this.f842e = -1L;
    }

    public C0272i(boolean z, int i, long j) {
        super(z);
        this.f841d = i;
        this.f859b = EnumC0275l.SUCCESS;
        this.f842e = j;
    }

    public C0272i(boolean z, int i, String str) {
        super(z, str);
        this.f841d = i;
        this.f859b = EnumC0275l.SUCCESS;
        this.f842e = -1L;
    }

    public C0272i(boolean z, int i, String str, long j) {
        super(z, str);
        this.f841d = i;
        this.f859b = EnumC0275l.SUCCESS;
        this.f842e = j;
    }

    public C0272i(boolean z, EnumC0275l enumC0275l) {
        super(z, enumC0275l);
        this.f841d = -1;
        this.f842e = -1L;
    }

    /* renamed from: f */
    public int m1365f() {
        return this.f841d;
    }

    /* renamed from: g */
    public long m1366g() {
        return this.f842e;
    }
}
