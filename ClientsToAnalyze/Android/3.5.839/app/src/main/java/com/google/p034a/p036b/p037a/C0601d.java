package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.p036b.InterfaceC0628ae;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: CollectionTypeAdapterFactory.java */
/* renamed from: com.google.a.b.a.d */
/* loaded from: classes.dex */
final class C0601d<E> extends AbstractC0562ae<Collection<E>> {

    /* renamed from: a */
    private final AbstractC0562ae<E> f1394a;

    /* renamed from: b */
    private final InterfaceC0628ae<? extends Collection<E>> f1395b;

    public C0601d(C0676j c0676j, Type type, AbstractC0562ae<E> abstractC0562ae, InterfaceC0628ae<? extends Collection<E>> interfaceC0628ae) {
        this.f1394a = new C0621x(c0676j, abstractC0562ae, type);
        this.f1395b = interfaceC0628ae;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Collection<E> mo1949b(C0666a c0666a) throws IOException {
        if (c0666a.mo1992f() == EnumC0668c.NULL) {
            c0666a.mo1996j();
            return null;
        }
        Collection<E> collectionMo2038a = this.f1395b.mo2038a();
        c0666a.mo1987a();
        while (c0666a.mo1991e()) {
            collectionMo2038a.add(this.f1394a.mo1949b(c0666a));
        }
        c0666a.mo1988b();
        return collectionMo2038a;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo1948a(C0669d c0669d, Collection<E> collection) throws IOException {
        if (collection == null) {
            c0669d.mo2014f();
            return;
        }
        c0669d.mo2009b();
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            this.f1394a.mo1948a(c0669d, it.next());
        }
        c0669d.mo2011c();
    }
}
