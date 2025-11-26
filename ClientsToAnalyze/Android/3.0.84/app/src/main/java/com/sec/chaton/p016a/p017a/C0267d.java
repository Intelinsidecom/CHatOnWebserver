package com.sec.chaton.p016a.p017a;

import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3250y;
import com.sec.common.p066d.p067a.C3319c;
import com.sec.common.p066d.p067a.p068a.C3317c;

/* compiled from: HttpEntry.java */
/* renamed from: com.sec.chaton.a.a.d */
/* loaded from: classes.dex */
public class C0267d extends C3317c {

    /* renamed from: a */
    private static final String f828a = C0267d.class.getSimpleName();

    /* renamed from: b */
    private Throwable f829b;

    /* renamed from: c */
    private Object f830c;

    public C0267d(C3319c c3319c) {
        super(c3319c);
        this.f830c = null;
    }

    /* renamed from: a */
    public void m1349a(Object obj) {
        this.f830c = obj;
    }

    /* renamed from: a */
    public Object m1348a() {
        return this.f830c;
    }

    /* renamed from: b */
    public EnumC1587o m1351b() {
        switch (C0268e.f831a[m1352c().ordinal()]) {
            case 1:
                return EnumC1587o.SUCCESS;
            case 2:
                return EnumC1587o.NO_CONTENT;
            case 3:
                return EnumC1587o.NO_REQUEST;
            case 4:
                return EnumC1587o.ERROR;
            default:
                throw new IllegalArgumentException("Unknown http result code");
        }
    }

    /* renamed from: c */
    public EnumC0270g m1352c() {
        if (m11703m() != 200) {
            if (m11703m() == 0) {
                if (this.f829b != null) {
                    return EnumC0270g.ERROR;
                }
                return EnumC0270g.NO_REQUEST;
            }
            if (m11703m() == 204) {
                return EnumC0270g.NO_CONTENT;
            }
            return EnumC0270g.ERROR;
        }
        if (this.f829b != null) {
            return EnumC0270g.ERROR;
        }
        return EnumC0270g.SUCCESS;
    }

    /* renamed from: d */
    public C1580h m1353d() {
        return (C1580h) m11701k();
    }

    /* renamed from: e */
    public Object m1354e() {
        return m11667p();
    }

    /* renamed from: f */
    public int m1355f() {
        try {
            C0269f c0269f = (C0269f) mo11666o();
            if (c0269f != null) {
                return c0269f.m1360a();
            }
            return 0;
        } catch (ClassCastException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f828a);
            }
            return 0;
        }
    }

    /* renamed from: g */
    public String m1356g() {
        try {
            C0269f c0269f = (C0269f) mo11666o();
            if (c0269f != null) {
                return c0269f.m1361b();
            }
            return null;
        } catch (ClassCastException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f828a);
            }
            return null;
        }
    }

    /* renamed from: h */
    public String m1357h() {
        return m1359j() != null ? m1359j().getMessage() : "";
    }

    /* renamed from: i */
    public int m1358i() {
        return m11703m();
    }

    /* renamed from: j */
    public Throwable m1359j() {
        return this.f829b;
    }

    /* renamed from: a */
    public void m1350a(Throwable th) {
        this.f829b = th;
    }
}
