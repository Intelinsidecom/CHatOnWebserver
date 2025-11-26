package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.AbstractC0686t;
import com.google.p034a.C0684r;
import com.google.p034a.C0688v;
import com.google.p034a.C0689w;
import com.google.p034a.C0691y;
import com.google.p034a.p036b.C0659v;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.ar */
/* loaded from: classes.dex */
final class C0584ar extends AbstractC0562ae<AbstractC0686t> {
    C0584ar() {
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC0686t mo1949b(C0666a c0666a) throws IOException {
        switch (c0666a.mo1992f()) {
            case NUMBER:
                return new C0691y(new C0659v(c0666a.mo1994h()));
            case BOOLEAN:
                return new C0691y(Boolean.valueOf(c0666a.mo1995i()));
            case STRING:
                return new C0691y(c0666a.mo1994h());
            case NULL:
                c0666a.mo1996j();
                return C0688v.f1623a;
            case BEGIN_ARRAY:
                C0684r c0684r = new C0684r();
                c0666a.mo1987a();
                while (c0666a.mo1991e()) {
                    c0684r.m2176a(mo1949b(c0666a));
                }
                c0666a.mo1988b();
                return c0684r;
            case BEGIN_OBJECT:
                C0689w c0689w = new C0689w();
                c0666a.mo1989c();
                while (c0666a.mo1991e()) {
                    c0689w.m2190a(c0666a.mo1993g(), mo1949b(c0666a));
                }
                c0666a.mo1990d();
                return c0689w;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo1948a(C0669d c0669d, AbstractC0686t abstractC0686t) throws IOException {
        if (abstractC0686t == null || abstractC0686t.m2185j()) {
            c0669d.mo2014f();
            return;
        }
        if (abstractC0686t.m2184i()) {
            C0691y c0691yM2188m = abstractC0686t.m2188m();
            if (c0691yM2188m.m2196p()) {
                c0669d.mo2005a(c0691yM2188m.mo2175a());
                return;
            } else if (c0691yM2188m.m2195o()) {
                c0669d.mo2007a(c0691yM2188m.mo2181f());
                return;
            } else {
                c0669d.mo2010b(c0691yM2188m.mo2177b());
                return;
            }
        }
        if (abstractC0686t.m2182g()) {
            c0669d.mo2009b();
            Iterator<AbstractC0686t> it = abstractC0686t.m2187l().iterator();
            while (it.hasNext()) {
                mo1948a(c0669d, it.next());
            }
            c0669d.mo2011c();
            return;
        }
        if (abstractC0686t.m2183h()) {
            c0669d.mo2012d();
            for (Map.Entry<String, AbstractC0686t> entry : abstractC0686t.m2186k().m2191o()) {
                c0669d.mo2006a(entry.getKey());
                mo1948a(c0669d, entry.getValue());
            }
            c0669d.mo2013e();
            return;
        }
        throw new IllegalArgumentException("Couldn't write " + abstractC0686t.getClass());
    }
}
