package com.google.p034a;

import com.google.p034a.p036b.C0630ag;
import com.google.p034a.p039d.C0669d;
import java.io.IOException;
import java.io.StringWriter;

/* compiled from: JsonElement.java */
/* renamed from: com.google.a.t */
/* loaded from: classes.dex */
public abstract class AbstractC0686t {
    /* renamed from: g */
    public boolean m2182g() {
        return this instanceof C0684r;
    }

    /* renamed from: h */
    public boolean m2183h() {
        return this instanceof C0689w;
    }

    /* renamed from: i */
    public boolean m2184i() {
        return this instanceof C0691y;
    }

    /* renamed from: j */
    public boolean m2185j() {
        return this instanceof C0688v;
    }

    /* renamed from: k */
    public C0689w m2186k() {
        if (m2183h()) {
            return (C0689w) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    /* renamed from: l */
    public C0684r m2187l() {
        if (m2182g()) {
            return (C0684r) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    /* renamed from: m */
    public C0691y m2188m() {
        if (m2184i()) {
            return (C0691y) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    /* renamed from: f */
    public boolean mo2181f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: n */
    Boolean mo2189n() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: a */
    public Number mo2175a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: b */
    public String mo2177b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: c */
    public double mo2178c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: d */
    public long mo2179d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: e */
    public int mo2180e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            C0669d c0669d = new C0669d(stringWriter);
            c0669d.m2142b(true);
            C0630ag.m2043a(this, c0669d);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
