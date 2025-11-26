package com.sec.chaton.p046a.p047a;

import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.p126d.p127a.C4987c;

/* compiled from: ChatONHttpTextResponseEntry.java */
/* renamed from: com.sec.chaton.a.a.b */
/* loaded from: classes.dex */
public class C0778b extends C0784h {

    /* renamed from: a */
    private static final String f2107a = C0778b.class.getSimpleName();

    /* renamed from: b */
    private Object f2108b;

    public C0778b(C4987c c4987c) {
        super(c4987c);
        this.f2108b = null;
    }

    /* renamed from: a */
    public void m3106a(Object obj) {
        this.f2108b = obj;
    }

    /* renamed from: a */
    public Object m3105a() {
        return this.f2108b;
    }

    /* renamed from: b */
    public EnumC2464o m3107b() {
        switch (C0779c.f2109a[m3108c().ordinal()]) {
            case 1:
                return EnumC2464o.SUCCESS;
            case 2:
                return EnumC2464o.NO_CONTENT;
            case 3:
                return EnumC2464o.NO_REQUEST;
            case 4:
                return EnumC2464o.ERROR;
            default:
                throw new IllegalArgumentException("Unknown http result code");
        }
    }

    /* renamed from: c */
    public EnumC0781e m3108c() {
        if (m18953m() != 200) {
            if (m18953m() == 0) {
                if (m3134j() != null) {
                    return EnumC0781e.ERROR;
                }
                return EnumC0781e.NO_REQUEST;
            }
            if (m18953m() == 204) {
                return EnumC0781e.NO_CONTENT;
            }
            return EnumC0781e.ERROR;
        }
        if (m3134j() != null) {
            return EnumC0781e.ERROR;
        }
        return EnumC0781e.SUCCESS;
    }

    /* renamed from: d */
    public C2454e m3109d() {
        return (C2454e) m18951k();
    }

    /* renamed from: e */
    public Object m3110e() {
        return m18928p();
    }

    /* renamed from: f */
    public int m3111f() {
        try {
            C0780d c0780d = (C0780d) mo18927o();
            if (c0780d != null) {
                return c0780d.m3115a();
            }
            return 0;
        } catch (ClassCastException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f2107a);
            }
            return 0;
        }
    }

    /* renamed from: g */
    public String m3112g() {
        try {
            C0780d c0780d = (C0780d) mo18927o();
            if (c0780d != null) {
                return c0780d.m3116b();
            }
            return null;
        } catch (ClassCastException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f2107a);
            }
            return null;
        }
    }

    /* renamed from: h */
    public String m3113h() {
        return m3134j() != null ? m3134j().getMessage() : "";
    }

    /* renamed from: i */
    public int m3114i() {
        return m18953m();
    }
}
