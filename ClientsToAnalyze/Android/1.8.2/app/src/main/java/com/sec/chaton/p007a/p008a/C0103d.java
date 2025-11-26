package com.sec.chaton.p007a.p008a;

/* compiled from: MessageResultEntry.java */
/* renamed from: com.sec.chaton.a.a.d */
/* loaded from: classes.dex */
public class C0103d extends C0105f {

    /* renamed from: d */
    private int f320d;

    /* renamed from: e */
    private long f321e;

    public C0103d(boolean z, int i) {
        super(z);
        this.f320d = i;
        this.f334b = EnumC0106g.SUCCESS;
        this.f321e = -1L;
    }

    public C0103d(boolean z, int i, String str) {
        super(z, str);
        this.f320d = i;
        this.f334b = EnumC0106g.SUCCESS;
        this.f321e = -1L;
    }

    public C0103d(boolean z, EnumC0106g enumC0106g) {
        super(z, enumC0106g);
        this.f320d = -1;
        this.f321e = -1L;
    }

    /* renamed from: a */
    public int m680a() {
        return this.f320d;
    }

    /* renamed from: b */
    public long m681b() {
        return this.f321e;
    }
}
