package com.google.p034a;

import com.google.p034a.p036b.C0629af;
import com.google.p034a.p036b.C0630ag;
import com.google.p034a.p036b.C0643f;
import com.google.p034a.p036b.C0656s;
import com.google.p034a.p036b.p037a.C0566a;
import com.google.p034a.p036b.p037a.C0600c;
import com.google.p034a.p036b.p037a.C0602e;
import com.google.p034a.p036b.p037a.C0608k;
import com.google.p034a.p036b.p037a.C0610m;
import com.google.p034a.p036b.p037a.C0613p;
import com.google.p034a.p036b.p037a.C0617t;
import com.google.p034a.p036b.p037a.C0619v;
import com.google.p034a.p036b.p037a.C0622y;
import com.google.p034a.p038c.C0664a;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.C0670e;
import com.google.p034a.p039d.EnumC0668c;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Gson.java */
/* renamed from: com.google.a.j */
/* loaded from: classes.dex */
public final class C0676j {

    /* renamed from: a */
    final InterfaceC0685s f1606a;

    /* renamed from: b */
    final InterfaceC0692z f1607b;

    /* renamed from: c */
    private final ThreadLocal<Map<C0664a<?>, C0682p<?>>> f1608c;

    /* renamed from: d */
    private final Map<C0664a<?>, AbstractC0562ae<?>> f1609d;

    /* renamed from: e */
    private final List<InterfaceC0563af> f1610e;

    /* renamed from: f */
    private final C0643f f1611f;

    /* renamed from: g */
    private final boolean f1612g;

    /* renamed from: h */
    private final boolean f1613h;

    /* renamed from: i */
    private final boolean f1614i;

    /* renamed from: j */
    private final boolean f1615j;

    public C0676j() {
        this(C0656s.f1535a, EnumC0663c.f1561a, Collections.emptyMap(), false, false, false, true, false, false, EnumC0559ab.f1371a, Collections.emptyList());
    }

    C0676j(C0656s c0656s, InterfaceC0675i interfaceC0675i, Map<Type, InterfaceC0683q<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, EnumC0559ab enumC0559ab, List<InterfaceC0563af> list) {
        this.f1608c = new ThreadLocal<>();
        this.f1609d = Collections.synchronizedMap(new HashMap());
        this.f1606a = new C0677k(this);
        this.f1607b = new C0678l(this);
        this.f1611f = new C0643f(map);
        this.f1612g = z;
        this.f1614i = z3;
        this.f1613h = z4;
        this.f1615j = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(C0622y.f1454Q);
        arrayList.add(C0610m.f1414a);
        arrayList.add(c0656s);
        arrayList.addAll(list);
        arrayList.add(C0622y.f1479x);
        arrayList.add(C0622y.f1468m);
        arrayList.add(C0622y.f1462g);
        arrayList.add(C0622y.f1464i);
        arrayList.add(C0622y.f1466k);
        arrayList.add(C0622y.m2031a(Long.TYPE, Long.class, m2149a(enumC0559ab)));
        arrayList.add(C0622y.m2031a(Double.TYPE, Double.class, m2150a(z6)));
        arrayList.add(C0622y.m2031a(Float.TYPE, Float.class, m2155b(z6)));
        arrayList.add(C0622y.f1473r);
        arrayList.add(C0622y.f1475t);
        arrayList.add(C0622y.f1481z);
        arrayList.add(C0622y.f1439B);
        arrayList.add(C0622y.m2030a(BigDecimal.class, C0622y.f1477v));
        arrayList.add(C0622y.m2030a(BigInteger.class, C0622y.f1478w));
        arrayList.add(C0622y.f1441D);
        arrayList.add(C0622y.f1443F);
        arrayList.add(C0622y.f1447J);
        arrayList.add(C0622y.f1452O);
        arrayList.add(C0622y.f1445H);
        arrayList.add(C0622y.f1459d);
        arrayList.add(C0602e.f1396a);
        arrayList.add(C0622y.f1450M);
        arrayList.add(C0619v.f1433a);
        arrayList.add(C0617t.f1431a);
        arrayList.add(C0622y.f1448K);
        arrayList.add(C0566a.f1375a);
        arrayList.add(C0622y.f1455R);
        arrayList.add(C0622y.f1457b);
        arrayList.add(new C0600c(this.f1611f));
        arrayList.add(new C0608k(this.f1611f, z2));
        arrayList.add(new C0613p(this.f1611f, interfaceC0675i, c0656s));
        this.f1610e = Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    private AbstractC0562ae<Number> m2150a(boolean z) {
        return z ? C0622y.f1471p : new C0679m(this);
    }

    /* renamed from: b */
    private AbstractC0562ae<Number> m2155b(boolean z) {
        return z ? C0622y.f1470o : new C0680n(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2152a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    /* renamed from: a */
    private AbstractC0562ae<Number> m2149a(EnumC0559ab enumC0559ab) {
        return enumC0559ab == EnumC0559ab.f1371a ? C0622y.f1469n : new C0681o(this);
    }

    /* renamed from: a */
    public <T> AbstractC0562ae<T> m2157a(C0664a<T> c0664a) {
        Map map;
        AbstractC0562ae<T> abstractC0562aeMo1950a = (AbstractC0562ae) this.f1609d.get(c0664a);
        if (abstractC0562aeMo1950a == null) {
            Map<C0664a<?>, C0682p<?>> map2 = this.f1608c.get();
            boolean z = false;
            if (map2 == null) {
                HashMap map3 = new HashMap();
                this.f1608c.set(map3);
                map = map3;
                z = true;
            } else {
                map = map2;
            }
            abstractC0562aeMo1950a = (C0682p) map.get(c0664a);
            if (abstractC0562aeMo1950a == null) {
                try {
                    C0682p c0682p = new C0682p();
                    map.put(c0664a, c0682p);
                    Iterator<InterfaceC0563af> it = this.f1610e.iterator();
                    while (it.hasNext()) {
                        abstractC0562aeMo1950a = it.next().mo1950a(this, c0664a);
                        if (abstractC0562aeMo1950a != null) {
                            c0682p.m2173a((AbstractC0562ae) abstractC0562aeMo1950a);
                            this.f1609d.put(c0664a, abstractC0562aeMo1950a);
                            map.remove(c0664a);
                            if (z) {
                                this.f1608c.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + c0664a);
                } catch (Throwable th) {
                    map.remove(c0664a);
                    if (z) {
                        this.f1608c.remove();
                    }
                    throw th;
                }
            }
        }
        return abstractC0562aeMo1950a;
    }

    /* renamed from: a */
    public <T> AbstractC0562ae<T> m2156a(InterfaceC0563af interfaceC0563af, C0664a<T> c0664a) {
        boolean z = false;
        for (InterfaceC0563af interfaceC0563af2 : this.f1610e) {
            if (!z) {
                if (interfaceC0563af2 == interfaceC0563af) {
                    z = true;
                }
            } else {
                AbstractC0562ae<T> abstractC0562aeMo1950a = interfaceC0563af2.mo1950a(this, c0664a);
                if (abstractC0562aeMo1950a != null) {
                    return abstractC0562aeMo1950a;
                }
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + c0664a);
    }

    /* renamed from: a */
    public <T> AbstractC0562ae<T> m2158a(Class<T> cls) {
        return m2157a((C0664a) C0664a.m2102b(cls));
    }

    /* renamed from: a */
    public String m2164a(Object obj) {
        return obj == null ? m2163a((AbstractC0686t) C0688v.f1623a) : m2165a(obj, obj.getClass());
    }

    /* renamed from: a */
    public String m2165a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        m2169a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    /* renamed from: a */
    public void m2169a(Object obj, Type type, Appendable appendable) {
        try {
            m2168a(obj, type, m2151a(C0630ag.m2042a(appendable)));
        } catch (IOException e) {
            throw new C0687u(e);
        }
    }

    /* renamed from: a */
    public void m2168a(Object obj, Type type, C0669d c0669d) {
        AbstractC0562ae abstractC0562aeM2157a = m2157a((C0664a) C0664a.m2100a(type));
        boolean zM2146g = c0669d.m2146g();
        c0669d.m2142b(true);
        boolean zM2147h = c0669d.m2147h();
        c0669d.m2144c(this.f1613h);
        boolean zM2148i = c0669d.m2148i();
        c0669d.m2145d(this.f1612g);
        try {
            try {
                abstractC0562aeM2157a.mo1948a(c0669d, obj);
            } catch (IOException e) {
                throw new C0687u(e);
            }
        } finally {
            c0669d.m2142b(zM2146g);
            c0669d.m2144c(zM2147h);
            c0669d.m2145d(zM2148i);
        }
    }

    /* renamed from: a */
    public String m2163a(AbstractC0686t abstractC0686t) {
        StringWriter stringWriter = new StringWriter();
        m2167a(abstractC0686t, stringWriter);
        return stringWriter.toString();
    }

    /* renamed from: a */
    public void m2167a(AbstractC0686t abstractC0686t, Appendable appendable) {
        try {
            m2166a(abstractC0686t, m2151a(C0630ag.m2042a(appendable)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private C0669d m2151a(Writer writer) throws IOException {
        if (this.f1614i) {
            writer.write(")]}'\n");
        }
        C0669d c0669d = new C0669d(writer);
        if (this.f1615j) {
            c0669d.m2143c("  ");
        }
        c0669d.m2145d(this.f1612g);
        return c0669d;
    }

    /* renamed from: a */
    public void m2166a(AbstractC0686t abstractC0686t, C0669d c0669d) {
        boolean zM2146g = c0669d.m2146g();
        c0669d.m2142b(true);
        boolean zM2147h = c0669d.m2147h();
        c0669d.m2144c(this.f1613h);
        boolean zM2148i = c0669d.m2148i();
        c0669d.m2145d(this.f1612g);
        try {
            try {
                C0630ag.m2043a(abstractC0686t, c0669d);
            } catch (IOException e) {
                throw new C0687u(e);
            }
        } finally {
            c0669d.m2142b(zM2146g);
            c0669d.m2144c(zM2147h);
            c0669d.m2145d(zM2148i);
        }
    }

    /* renamed from: a */
    public <T> T m2161a(String str, Class<T> cls) {
        return (T) C0629af.m2039a((Class) cls).cast(m2162a(str, (Type) cls));
    }

    /* renamed from: a */
    public <T> T m2162a(String str, Type type) {
        if (str == null) {
            return null;
        }
        return (T) m2160a((Reader) new StringReader(str), type);
    }

    /* renamed from: a */
    public <T> T m2160a(Reader reader, Type type) {
        C0666a c0666a = new C0666a(reader);
        T t = (T) m2159a(c0666a, type);
        m2154a(t, c0666a);
        return t;
    }

    /* renamed from: a */
    private static void m2154a(Object obj, C0666a c0666a) {
        if (obj != null) {
            try {
                if (c0666a.mo1992f() != EnumC0668c.END_DOCUMENT) {
                    throw new C0687u("JSON document was not fully consumed.");
                }
            } catch (C0670e e) {
                throw new C0558aa(e);
            } catch (IOException e2) {
                throw new C0687u(e2);
            }
        }
    }

    /* renamed from: a */
    public <T> T m2159a(C0666a c0666a, Type type) {
        boolean z = true;
        boolean zM2131p = c0666a.m2131p();
        c0666a.m2130a(true);
        try {
            try {
                c0666a.mo1992f();
                z = false;
                T tMo1949b = m2157a((C0664a) C0664a.m2100a(type)).mo1949b(c0666a);
                c0666a.m2130a(zM2131p);
                return tMo1949b;
            } catch (EOFException e) {
                if (!z) {
                    throw new C0558aa(e);
                }
                c0666a.m2130a(zM2131p);
                return null;
            } catch (IOException e2) {
                throw new C0558aa(e2);
            } catch (IllegalStateException e3) {
                throw new C0558aa(e3);
            }
        } catch (Throwable th) {
            c0666a.m2130a(zM2131p);
            throw th;
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f1612g + "factories:" + this.f1610e + ",instanceCreators:" + this.f1611f + "}";
    }
}
