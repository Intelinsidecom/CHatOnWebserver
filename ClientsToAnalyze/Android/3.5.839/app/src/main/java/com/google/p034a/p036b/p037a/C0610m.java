package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p036b.C0660w;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ObjectTypeAdapter.java */
/* renamed from: com.google.a.b.a.m */
/* loaded from: classes.dex */
public final class C0610m extends AbstractC0562ae<Object> {

    /* renamed from: a */
    public static final InterfaceC0563af f1414a = new C0611n();

    /* renamed from: b */
    private final C0676j f1415b;

    /* synthetic */ C0610m(C0676j c0676j, C0611n c0611n) {
        this(c0676j);
    }

    private C0610m(C0676j c0676j) {
        this.f1415b = c0676j;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: b */
    public Object mo1949b(C0666a c0666a) throws IOException {
        switch (C0612o.f1416a[c0666a.mo1992f().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                c0666a.mo1987a();
                while (c0666a.mo1991e()) {
                    arrayList.add(mo1949b(c0666a));
                }
                c0666a.mo1988b();
                return arrayList;
            case 2:
                C0660w c0660w = new C0660w();
                c0666a.mo1989c();
                while (c0666a.mo1991e()) {
                    c0660w.put(c0666a.mo1993g(), mo1949b(c0666a));
                }
                c0666a.mo1990d();
                return c0660w;
            case 3:
                return c0666a.mo1994h();
            case 4:
                return Double.valueOf(c0666a.mo1997k());
            case 5:
                return Boolean.valueOf(c0666a.mo1995i());
            case 6:
                c0666a.mo1996j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a */
    public void mo1948a(C0669d c0669d, Object obj) throws IOException {
        if (obj == null) {
            c0669d.mo2014f();
            return;
        }
        AbstractC0562ae abstractC0562aeM2158a = this.f1415b.m2158a((Class) obj.getClass());
        if (abstractC0562aeM2158a instanceof C0610m) {
            c0669d.mo2012d();
            c0669d.mo2013e();
        } else {
            abstractC0562aeM2158a.mo1948a(c0669d, obj);
        }
    }
}
