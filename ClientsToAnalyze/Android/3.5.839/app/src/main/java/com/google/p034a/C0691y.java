package com.google.p034a;

import com.google.p034a.p036b.C0565a;
import com.google.p034a.p036b.C0659v;
import java.math.BigInteger;

/* compiled from: JsonPrimitive.java */
/* renamed from: com.google.a.y */
/* loaded from: classes.dex */
public final class C0691y extends AbstractC0686t {

    /* renamed from: a */
    private static final Class<?>[] f1625a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: b */
    private Object f1626b;

    public C0691y(Boolean bool) {
        m2194a(bool);
    }

    public C0691y(Number number) {
        m2194a(number);
    }

    public C0691y(String str) {
        m2194a(str);
    }

    /* renamed from: a */
    void m2194a(Object obj) {
        if (obj instanceof Character) {
            this.f1626b = String.valueOf(((Character) obj).charValue());
        } else {
            C0565a.m1952a((obj instanceof Number) || m2193b(obj));
            this.f1626b = obj;
        }
    }

    /* renamed from: o */
    public boolean m2195o() {
        return this.f1626b instanceof Boolean;
    }

    @Override // com.google.p034a.AbstractC0686t
    /* renamed from: n */
    Boolean mo2189n() {
        return (Boolean) this.f1626b;
    }

    @Override // com.google.p034a.AbstractC0686t
    /* renamed from: f */
    public boolean mo2181f() {
        return m2195o() ? mo2189n().booleanValue() : Boolean.parseBoolean(mo2177b());
    }

    /* renamed from: p */
    public boolean m2196p() {
        return this.f1626b instanceof Number;
    }

    @Override // com.google.p034a.AbstractC0686t
    /* renamed from: a */
    public Number mo2175a() {
        return this.f1626b instanceof String ? new C0659v((String) this.f1626b) : (Number) this.f1626b;
    }

    /* renamed from: q */
    public boolean m2197q() {
        return this.f1626b instanceof String;
    }

    @Override // com.google.p034a.AbstractC0686t
    /* renamed from: b */
    public String mo2177b() {
        if (m2196p()) {
            return mo2175a().toString();
        }
        if (m2195o()) {
            return mo2189n().toString();
        }
        return (String) this.f1626b;
    }

    @Override // com.google.p034a.AbstractC0686t
    /* renamed from: c */
    public double mo2178c() {
        return m2196p() ? mo2175a().doubleValue() : Double.parseDouble(mo2177b());
    }

    @Override // com.google.p034a.AbstractC0686t
    /* renamed from: d */
    public long mo2179d() {
        return m2196p() ? mo2175a().longValue() : Long.parseLong(mo2177b());
    }

    @Override // com.google.p034a.AbstractC0686t
    /* renamed from: e */
    public int mo2180e() {
        return m2196p() ? mo2175a().intValue() : Integer.parseInt(mo2177b());
    }

    /* renamed from: b */
    private static boolean m2193b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : f1625a) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f1626b == null) {
            return 31;
        }
        if (m2192a(this)) {
            long jLongValue = mo2175a().longValue();
            return (int) (jLongValue ^ (jLongValue >>> 32));
        }
        if (this.f1626b instanceof Number) {
            long jDoubleToLongBits = Double.doubleToLongBits(mo2175a().doubleValue());
            return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        }
        return this.f1626b.hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0691y c0691y = (C0691y) obj;
        if (this.f1626b == null) {
            return c0691y.f1626b == null;
        }
        if (m2192a(this) && m2192a(c0691y)) {
            return mo2175a().longValue() == c0691y.mo2175a().longValue();
        }
        if ((this.f1626b instanceof Number) && (c0691y.f1626b instanceof Number)) {
            double dDoubleValue = mo2175a().doubleValue();
            double dDoubleValue2 = c0691y.mo2175a().doubleValue();
            if (dDoubleValue == dDoubleValue2 || (Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2))) {
                z = true;
            }
            return z;
        }
        return this.f1626b.equals(c0691y.f1626b);
    }

    /* renamed from: a */
    private static boolean m2192a(C0691y c0691y) {
        if (!(c0691y.f1626b instanceof Number)) {
            return false;
        }
        Number number = (Number) c0691y.f1626b;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }
}
