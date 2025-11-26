package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.p035a.InterfaceC0555b;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;
import java.lang.Enum;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.bf */
/* loaded from: classes.dex */
final class C0599bf<T extends Enum<T>> extends AbstractC0562ae<T> {

    /* renamed from: a */
    private final Map<String, T> f1391a = new HashMap();

    /* renamed from: b */
    private final Map<T, String> f1392b = new HashMap();

    public C0599bf(Class<T> cls) {
        try {
            for (T t : cls.getEnumConstants()) {
                String strName = t.name();
                InterfaceC0555b interfaceC0555b = (InterfaceC0555b) cls.getField(strName).getAnnotation(InterfaceC0555b.class);
                String strM1944a = interfaceC0555b != null ? interfaceC0555b.m1944a() : strName;
                this.f1391a.put(strM1944a, t);
                this.f1392b.put(t, strM1944a);
            }
        } catch (NoSuchFieldException e) {
            throw new AssertionError();
        }
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public T mo1949b(C0666a c0666a) throws IOException {
        if (c0666a.mo1992f() != EnumC0668c.NULL) {
            return this.f1391a.get(c0666a.mo1994h());
        }
        c0666a.mo1996j();
        return null;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo1948a(C0669d c0669d, T t) throws IOException {
        c0669d.mo2010b(t == null ? null : this.f1392b.get(t));
    }
}
