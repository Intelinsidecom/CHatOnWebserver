package com.google.p034a.p036b.p037a;

import com.google.p034a.C0684r;
import com.google.p034a.C0688v;
import com.google.p034a.C0689w;
import com.google.p034a.C0691y;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.EnumC0668c;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: JsonTreeReader.java */
/* renamed from: com.google.a.b.a.g */
/* loaded from: classes.dex */
public final class C0604g extends C0666a {

    /* renamed from: a */
    private static final Reader f1400a = new C0605h();

    /* renamed from: b */
    private static final Object f1401b = new Object();

    /* renamed from: c */
    private final List<Object> f1402c;

    @Override // com.google.p034a.p039d.C0666a
    /* renamed from: a */
    public void mo1987a() {
        m1984a(EnumC0668c.BEGIN_ARRAY);
        this.f1402c.add(((C0684r) m1985q()).iterator());
    }

    @Override // com.google.p034a.p039d.C0666a
    /* renamed from: b */
    public void mo1988b() {
        m1984a(EnumC0668c.END_ARRAY);
        m1986r();
        m1986r();
    }

    @Override // com.google.p034a.p039d.C0666a
    /* renamed from: c */
    public void mo1989c() {
        m1984a(EnumC0668c.BEGIN_OBJECT);
        this.f1402c.add(((C0689w) m1985q()).m2191o().iterator());
    }

    @Override // com.google.p034a.p039d.C0666a
    /* renamed from: d */
    public void mo1990d() {
        m1984a(EnumC0668c.END_OBJECT);
        m1986r();
        m1986r();
    }

    @Override // com.google.p034a.p039d.C0666a
    /* renamed from: e */
    public boolean mo1991e() {
        EnumC0668c enumC0668cMo1992f = mo1992f();
        return (enumC0668cMo1992f == EnumC0668c.END_OBJECT || enumC0668cMo1992f == EnumC0668c.END_ARRAY) ? false : true;
    }

    @Override // com.google.p034a.p039d.C0666a
    /* renamed from: f */
    public EnumC0668c mo1992f() {
        if (this.f1402c.isEmpty()) {
            return EnumC0668c.END_DOCUMENT;
        }
        Object objM1985q = m1985q();
        if (objM1985q instanceof Iterator) {
            boolean z = this.f1402c.get(this.f1402c.size() - 2) instanceof C0689w;
            Iterator it = (Iterator) objM1985q;
            if (!it.hasNext()) {
                return z ? EnumC0668c.END_OBJECT : EnumC0668c.END_ARRAY;
            }
            if (z) {
                return EnumC0668c.NAME;
            }
            this.f1402c.add(it.next());
            return mo1992f();
        }
        if (objM1985q instanceof C0689w) {
            return EnumC0668c.BEGIN_OBJECT;
        }
        if (objM1985q instanceof C0684r) {
            return EnumC0668c.BEGIN_ARRAY;
        }
        if (objM1985q instanceof C0691y) {
            C0691y c0691y = (C0691y) objM1985q;
            if (c0691y.m2197q()) {
                return EnumC0668c.STRING;
            }
            if (c0691y.m2195o()) {
                return EnumC0668c.BOOLEAN;
            }
            if (c0691y.m2196p()) {
                return EnumC0668c.NUMBER;
            }
            throw new AssertionError();
        }
        if (objM1985q instanceof C0688v) {
            return EnumC0668c.NULL;
        }
        if (objM1985q == f1401b) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new AssertionError();
    }

    /* renamed from: q */
    private Object m1985q() {
        return this.f1402c.get(this.f1402c.size() - 1);
    }

    /* renamed from: r */
    private Object m1986r() {
        return this.f1402c.remove(this.f1402c.size() - 1);
    }

    /* renamed from: a */
    private void m1984a(EnumC0668c enumC0668c) {
        if (mo1992f() != enumC0668c) {
            throw new IllegalStateException("Expected " + enumC0668c + " but was " + mo1992f());
        }
    }

    @Override // com.google.p034a.p039d.C0666a
    /* renamed from: g */
    public String mo1993g() {
        m1984a(EnumC0668c.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m1985q()).next();
        this.f1402c.add(entry.getValue());
        return (String) entry.getKey();
    }

    @Override // com.google.p034a.p039d.C0666a
    /* renamed from: h */
    public String mo1994h() {
        EnumC0668c enumC0668cMo1992f = mo1992f();
        if (enumC0668cMo1992f != EnumC0668c.STRING && enumC0668cMo1992f != EnumC0668c.NUMBER) {
            throw new IllegalStateException("Expected " + EnumC0668c.STRING + " but was " + enumC0668cMo1992f);
        }
        return ((C0691y) m1986r()).mo2177b();
    }

    @Override // com.google.p034a.p039d.C0666a
    /* renamed from: i */
    public boolean mo1995i() {
        m1984a(EnumC0668c.BOOLEAN);
        return ((C0691y) m1986r()).mo2181f();
    }

    @Override // com.google.p034a.p039d.C0666a
    /* renamed from: j */
    public void mo1996j() {
        m1984a(EnumC0668c.NULL);
        m1986r();
    }

    @Override // com.google.p034a.p039d.C0666a
    /* renamed from: k */
    public double mo1997k() {
        EnumC0668c enumC0668cMo1992f = mo1992f();
        if (enumC0668cMo1992f != EnumC0668c.NUMBER && enumC0668cMo1992f != EnumC0668c.STRING) {
            throw new IllegalStateException("Expected " + EnumC0668c.NUMBER + " but was " + enumC0668cMo1992f);
        }
        double dMo2178c = ((C0691y) m1985q()).mo2178c();
        if (!m2131p() && (Double.isNaN(dMo2178c) || Double.isInfinite(dMo2178c))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + dMo2178c);
        }
        m1986r();
        return dMo2178c;
    }

    @Override // com.google.p034a.p039d.C0666a
    /* renamed from: l */
    public long mo1998l() {
        EnumC0668c enumC0668cMo1992f = mo1992f();
        if (enumC0668cMo1992f != EnumC0668c.NUMBER && enumC0668cMo1992f != EnumC0668c.STRING) {
            throw new IllegalStateException("Expected " + EnumC0668c.NUMBER + " but was " + enumC0668cMo1992f);
        }
        long jMo2179d = ((C0691y) m1985q()).mo2179d();
        m1986r();
        return jMo2179d;
    }

    @Override // com.google.p034a.p039d.C0666a
    /* renamed from: m */
    public int mo1999m() {
        EnumC0668c enumC0668cMo1992f = mo1992f();
        if (enumC0668cMo1992f != EnumC0668c.NUMBER && enumC0668cMo1992f != EnumC0668c.STRING) {
            throw new IllegalStateException("Expected " + EnumC0668c.NUMBER + " but was " + enumC0668cMo1992f);
        }
        int iMo2180e = ((C0691y) m1985q()).mo2180e();
        m1986r();
        return iMo2180e;
    }

    @Override // com.google.p034a.p039d.C0666a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1402c.clear();
        this.f1402c.add(f1401b);
    }

    @Override // com.google.p034a.p039d.C0666a
    /* renamed from: n */
    public void mo2000n() {
        if (mo1992f() == EnumC0668c.NAME) {
            mo1993g();
        } else {
            m1986r();
        }
    }

    @Override // com.google.p034a.p039d.C0666a
    public String toString() {
        return getClass().getSimpleName();
    }

    /* renamed from: o */
    public void m2001o() {
        m1984a(EnumC0668c.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m1985q()).next();
        this.f1402c.add(entry.getValue());
        this.f1402c.add(new C0691y((String) entry.getKey()));
    }
}
