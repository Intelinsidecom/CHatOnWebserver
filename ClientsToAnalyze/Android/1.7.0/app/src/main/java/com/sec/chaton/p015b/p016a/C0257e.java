package com.sec.chaton.p015b.p016a;

/* compiled from: MessageResultEntry.java */
/* renamed from: com.sec.chaton.b.a.e */
/* loaded from: classes.dex */
public class C0257e extends C0254b {

    /* renamed from: d */
    private int f622d;

    /* renamed from: e */
    private long f623e;

    public C0257e(boolean z, int i) {
        super(z);
        this.f622d = i;
        this.f605b = EnumC0256d.SUCCESS;
        this.f623e = -1L;
    }

    public C0257e(boolean z, int i, long j) {
        super(z);
        this.f622d = i;
        this.f605b = EnumC0256d.SUCCESS;
        this.f623e = j;
    }

    public C0257e(boolean z, int i, String str) {
        super(z, str);
        this.f622d = i;
        this.f605b = EnumC0256d.SUCCESS;
        this.f623e = -1L;
    }

    public C0257e(boolean z, int i, String str, long j) {
        super(z, str);
        this.f622d = i;
        this.f605b = EnumC0256d.SUCCESS;
        this.f623e = j;
    }

    public C0257e(boolean z, EnumC0256d enumC0256d) {
        super(z, enumC0256d);
        this.f622d = -1;
        this.f623e = -1L;
    }

    /* renamed from: b */
    public int m917b() {
        return this.f622d;
    }

    /* renamed from: c */
    public long m918c() {
        return this.f623e;
    }
}
