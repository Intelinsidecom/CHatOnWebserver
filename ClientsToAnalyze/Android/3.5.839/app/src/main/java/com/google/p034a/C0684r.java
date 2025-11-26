package com.google.p034a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: JsonArray.java */
/* renamed from: com.google.a.r */
/* loaded from: classes.dex */
public final class C0684r extends AbstractC0686t implements Iterable<AbstractC0686t> {

    /* renamed from: a */
    private final List<AbstractC0686t> f1622a = new ArrayList();

    /* renamed from: a */
    public void m2176a(AbstractC0686t abstractC0686t) {
        if (abstractC0686t == null) {
            abstractC0686t = C0688v.f1623a;
        }
        this.f1622a.add(abstractC0686t);
    }

    @Override // java.lang.Iterable
    public Iterator<AbstractC0686t> iterator() {
        return this.f1622a.iterator();
    }

    @Override // com.google.p034a.AbstractC0686t
    /* renamed from: a */
    public Number mo2175a() {
        if (this.f1622a.size() == 1) {
            return this.f1622a.get(0).mo2175a();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.p034a.AbstractC0686t
    /* renamed from: b */
    public String mo2177b() {
        if (this.f1622a.size() == 1) {
            return this.f1622a.get(0).mo2177b();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.p034a.AbstractC0686t
    /* renamed from: c */
    public double mo2178c() {
        if (this.f1622a.size() == 1) {
            return this.f1622a.get(0).mo2178c();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.p034a.AbstractC0686t
    /* renamed from: d */
    public long mo2179d() {
        if (this.f1622a.size() == 1) {
            return this.f1622a.get(0).mo2179d();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.p034a.AbstractC0686t
    /* renamed from: e */
    public int mo2180e() {
        if (this.f1622a.size() == 1) {
            return this.f1622a.get(0).mo2180e();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.p034a.AbstractC0686t
    /* renamed from: f */
    public boolean mo2181f() {
        if (this.f1622a.size() == 1) {
            return this.f1622a.get(0).mo2181f();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C0684r) && ((C0684r) obj).f1622a.equals(this.f1622a));
    }

    public int hashCode() {
        return this.f1622a.hashCode();
    }
}
