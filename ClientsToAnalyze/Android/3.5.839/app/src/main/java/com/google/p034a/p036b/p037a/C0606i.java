package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0686t;
import com.google.p034a.C0684r;
import com.google.p034a.C0688v;
import com.google.p034a.C0689w;
import com.google.p034a.C0691y;
import com.google.p034a.p039d.C0669d;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonTreeWriter.java */
/* renamed from: com.google.a.b.a.i */
/* loaded from: classes.dex */
public final class C0606i extends C0669d {

    /* renamed from: a */
    private static final Writer f1403a = new C0607j();

    /* renamed from: b */
    private static final C0691y f1404b = new C0691y("closed");

    /* renamed from: c */
    private final List<AbstractC0686t> f1405c;

    /* renamed from: d */
    private String f1406d;

    /* renamed from: e */
    private AbstractC0686t f1407e;

    public C0606i() {
        super(f1403a);
        this.f1405c = new ArrayList();
        this.f1407e = C0688v.f1623a;
    }

    /* renamed from: a */
    public AbstractC0686t m2008a() {
        if (!this.f1405c.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.f1405c);
        }
        return this.f1407e;
    }

    /* renamed from: j */
    private AbstractC0686t m2003j() {
        return this.f1405c.get(this.f1405c.size() - 1);
    }

    /* renamed from: a */
    private void m2002a(AbstractC0686t abstractC0686t) {
        if (this.f1406d != null) {
            if (!abstractC0686t.m2185j() || m2148i()) {
                ((C0689w) m2003j()).m2190a(this.f1406d, abstractC0686t);
            }
            this.f1406d = null;
            return;
        }
        if (this.f1405c.isEmpty()) {
            this.f1407e = abstractC0686t;
            return;
        }
        AbstractC0686t abstractC0686tM2003j = m2003j();
        if (abstractC0686tM2003j instanceof C0684r) {
            ((C0684r) abstractC0686tM2003j).m2176a(abstractC0686t);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.p034a.p039d.C0669d
    /* renamed from: b */
    public C0669d mo2009b() {
        C0684r c0684r = new C0684r();
        m2002a(c0684r);
        this.f1405c.add(c0684r);
        return this;
    }

    @Override // com.google.p034a.p039d.C0669d
    /* renamed from: c */
    public C0669d mo2011c() {
        if (this.f1405c.isEmpty() || this.f1406d != null) {
            throw new IllegalStateException();
        }
        if (m2003j() instanceof C0684r) {
            this.f1405c.remove(this.f1405c.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.p034a.p039d.C0669d
    /* renamed from: d */
    public C0669d mo2012d() {
        C0689w c0689w = new C0689w();
        m2002a(c0689w);
        this.f1405c.add(c0689w);
        return this;
    }

    @Override // com.google.p034a.p039d.C0669d
    /* renamed from: e */
    public C0669d mo2013e() {
        if (this.f1405c.isEmpty() || this.f1406d != null) {
            throw new IllegalStateException();
        }
        if (m2003j() instanceof C0689w) {
            this.f1405c.remove(this.f1405c.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.p034a.p039d.C0669d
    /* renamed from: a */
    public C0669d mo2006a(String str) {
        if (this.f1405c.isEmpty() || this.f1406d != null) {
            throw new IllegalStateException();
        }
        if (m2003j() instanceof C0689w) {
            this.f1406d = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.p034a.p039d.C0669d
    /* renamed from: b */
    public C0669d mo2010b(String str) {
        if (str == null) {
            return mo2014f();
        }
        m2002a(new C0691y(str));
        return this;
    }

    @Override // com.google.p034a.p039d.C0669d
    /* renamed from: f */
    public C0669d mo2014f() {
        m2002a(C0688v.f1623a);
        return this;
    }

    @Override // com.google.p034a.p039d.C0669d
    /* renamed from: a */
    public C0669d mo2007a(boolean z) {
        m2002a(new C0691y(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.p034a.p039d.C0669d
    /* renamed from: a */
    public C0669d mo2004a(long j) {
        m2002a(new C0691y(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.p034a.p039d.C0669d
    /* renamed from: a */
    public C0669d mo2005a(Number number) {
        if (number == null) {
            return mo2014f();
        }
        if (!m2146g()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        m2002a(new C0691y(number));
        return this;
    }

    @Override // com.google.p034a.p039d.C0669d, java.io.Flushable
    public void flush() {
    }

    @Override // com.google.p034a.p039d.C0669d, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f1405c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f1405c.add(f1404b);
    }
}
