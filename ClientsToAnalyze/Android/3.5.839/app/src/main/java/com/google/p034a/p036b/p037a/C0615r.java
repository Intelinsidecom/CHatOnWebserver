package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0558aa;
import com.google.p034a.p036b.InterfaceC0628ae;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory.java */
/* renamed from: com.google.a.b.a.r */
/* loaded from: classes.dex */
public final class C0615r<T> extends AbstractC0562ae<T> {

    /* renamed from: a */
    private final InterfaceC0628ae<T> f1426a;

    /* renamed from: b */
    private final Map<String, AbstractC0616s> f1427b;

    /* synthetic */ C0615r(InterfaceC0628ae interfaceC0628ae, Map map, C0614q c0614q) {
        this(interfaceC0628ae, map);
    }

    private C0615r(InterfaceC0628ae<T> interfaceC0628ae, Map<String, AbstractC0616s> map) {
        this.f1426a = interfaceC0628ae;
        this.f1427b = map;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: b */
    public T mo1949b(C0666a c0666a) throws IOException {
        if (c0666a.mo1992f() == EnumC0668c.NULL) {
            c0666a.mo1996j();
            return null;
        }
        T tMo2038a = this.f1426a.mo2038a();
        try {
            c0666a.mo1989c();
            while (c0666a.mo1991e()) {
                AbstractC0616s abstractC0616s = this.f1427b.get(c0666a.mo1993g());
                if (abstractC0616s == null || !abstractC0616s.f1430i) {
                    c0666a.mo2000n();
                } else {
                    abstractC0616s.mo2024a(c0666a, tMo2038a);
                }
            }
            c0666a.mo1990d();
            return tMo2038a;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (IllegalStateException e2) {
            throw new C0558aa(e2);
        }
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a */
    public void mo1948a(C0669d c0669d, T t) throws IOException {
        if (t == null) {
            c0669d.mo2014f();
            return;
        }
        c0669d.mo2012d();
        try {
            for (AbstractC0616s abstractC0616s : this.f1427b.values()) {
                if (abstractC0616s.f1429h) {
                    c0669d.mo2006a(abstractC0616s.f1428g);
                    abstractC0616s.mo2025a(c0669d, t);
                }
            }
            c0669d.mo2013e();
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        }
    }
}
