package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.AbstractC0686t;
import com.google.p034a.C0558aa;
import com.google.p034a.C0676j;
import com.google.p034a.C0691y;
import com.google.p034a.p036b.AbstractC0658u;
import com.google.p034a.p036b.C0630ag;
import com.google.p034a.p036b.InterfaceC0628ae;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: MapTypeAdapterFactory.java */
/* renamed from: com.google.a.b.a.l */
/* loaded from: classes.dex */
final class C0609l<K, V> extends AbstractC0562ae<Map<K, V>> {

    /* renamed from: a */
    final /* synthetic */ C0608k f1410a;

    /* renamed from: b */
    private final AbstractC0562ae<K> f1411b;

    /* renamed from: c */
    private final AbstractC0562ae<V> f1412c;

    /* renamed from: d */
    private final InterfaceC0628ae<? extends Map<K, V>> f1413d;

    public C0609l(C0608k c0608k, C0676j c0676j, Type type, AbstractC0562ae<K> abstractC0562ae, Type type2, AbstractC0562ae<V> abstractC0562ae2, InterfaceC0628ae<? extends Map<K, V>> interfaceC0628ae) {
        this.f1410a = c0608k;
        this.f1411b = new C0621x(c0676j, abstractC0562ae, type);
        this.f1412c = new C0621x(c0676j, abstractC0562ae2, type2);
        this.f1413d = interfaceC0628ae;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<K, V> mo1949b(C0666a c0666a) throws IOException {
        EnumC0668c enumC0668cMo1992f = c0666a.mo1992f();
        if (enumC0668cMo1992f == EnumC0668c.NULL) {
            c0666a.mo1996j();
            return null;
        }
        Map<K, V> mapMo2038a = this.f1413d.mo2038a();
        if (enumC0668cMo1992f == EnumC0668c.BEGIN_ARRAY) {
            c0666a.mo1987a();
            while (c0666a.mo1991e()) {
                c0666a.mo1987a();
                K kMo1949b = this.f1411b.mo1949b(c0666a);
                if (mapMo2038a.put(kMo1949b, this.f1412c.mo1949b(c0666a)) != null) {
                    throw new C0558aa("duplicate key: " + kMo1949b);
                }
                c0666a.mo1988b();
            }
            c0666a.mo1988b();
            return mapMo2038a;
        }
        c0666a.mo1989c();
        while (c0666a.mo1991e()) {
            AbstractC0658u.f1548a.mo2082a(c0666a);
            K kMo1949b2 = this.f1411b.mo1949b(c0666a);
            if (mapMo2038a.put(kMo1949b2, this.f1412c.mo1949b(c0666a)) != null) {
                throw new C0558aa("duplicate key: " + kMo1949b2);
            }
        }
        c0666a.mo1990d();
        return mapMo2038a;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo1948a(C0669d c0669d, Map<K, V> map) throws IOException {
        int i = 0;
        if (map != null) {
            if (!this.f1410a.f1409b) {
                c0669d.mo2012d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    c0669d.mo2006a(String.valueOf(entry.getKey()));
                    this.f1412c.mo1948a(c0669d, entry.getValue());
                }
                c0669d.mo2013e();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                AbstractC0686t abstractC0686tM1947a = this.f1411b.m1947a(entry2.getKey());
                arrayList.add(abstractC0686tM1947a);
                arrayList2.add(entry2.getValue());
                z = (abstractC0686tM1947a.m2182g() || abstractC0686tM1947a.m2183h()) | z;
            }
            if (z) {
                c0669d.mo2009b();
                while (i < arrayList.size()) {
                    c0669d.mo2009b();
                    C0630ag.m2043a((AbstractC0686t) arrayList.get(i), c0669d);
                    this.f1412c.mo1948a(c0669d, arrayList2.get(i));
                    c0669d.mo2011c();
                    i++;
                }
                c0669d.mo2011c();
                return;
            }
            c0669d.mo2012d();
            while (i < arrayList.size()) {
                c0669d.mo2006a(m2017a((AbstractC0686t) arrayList.get(i)));
                this.f1412c.mo1948a(c0669d, arrayList2.get(i));
                i++;
            }
            c0669d.mo2013e();
            return;
        }
        c0669d.mo2014f();
    }

    /* renamed from: a */
    private String m2017a(AbstractC0686t abstractC0686t) {
        if (abstractC0686t.m2184i()) {
            C0691y c0691yM2188m = abstractC0686t.m2188m();
            if (c0691yM2188m.m2196p()) {
                return String.valueOf(c0691yM2188m.mo2175a());
            }
            if (c0691yM2188m.m2195o()) {
                return Boolean.toString(c0691yM2188m.mo2181f());
            }
            if (c0691yM2188m.m2197q()) {
                return c0691yM2188m.mo2177b();
            }
            throw new AssertionError();
        }
        if (abstractC0686t.m2185j()) {
            return "null";
        }
        throw new AssertionError();
    }
}
