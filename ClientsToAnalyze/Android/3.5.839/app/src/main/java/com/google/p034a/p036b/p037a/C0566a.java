package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* compiled from: ArrayTypeAdapter.java */
/* renamed from: com.google.a.b.a.a */
/* loaded from: classes.dex */
public final class C0566a<E> extends AbstractC0562ae<Object> {

    /* renamed from: a */
    public static final InterfaceC0563af f1375a = new C0593b();

    /* renamed from: b */
    private final Class<E> f1376b;

    /* renamed from: c */
    private final AbstractC0562ae<E> f1377c;

    public C0566a(C0676j c0676j, AbstractC0562ae<E> abstractC0562ae, Class<E> cls) {
        this.f1377c = new C0621x(c0676j, abstractC0562ae, cls);
        this.f1376b = cls;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: b */
    public Object mo1949b(C0666a c0666a) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (c0666a.mo1992f() == EnumC0668c.NULL) {
            c0666a.mo1996j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        c0666a.mo1987a();
        while (c0666a.mo1991e()) {
            arrayList.add(this.f1377c.mo1949b(c0666a));
        }
        c0666a.mo1988b();
        Object objNewInstance = Array.newInstance((Class<?>) this.f1376b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a */
    public void mo1948a(C0669d c0669d, Object obj) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == null) {
            c0669d.mo2014f();
            return;
        }
        c0669d.mo2009b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f1377c.mo1948a(c0669d, Array.get(obj, i));
        }
        c0669d.mo2011c();
    }
}
