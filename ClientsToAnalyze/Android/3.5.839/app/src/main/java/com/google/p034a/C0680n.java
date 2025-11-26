package com.google.p034a;

import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;

/* compiled from: Gson.java */
/* renamed from: com.google.a.n */
/* loaded from: classes.dex */
class C0680n extends AbstractC0562ae<Number> {

    /* renamed from: a */
    final /* synthetic */ C0676j f1619a;

    C0680n(C0676j c0676j) {
        this.f1619a = c0676j;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float mo1949b(C0666a c0666a) throws IOException {
        if (c0666a.mo1992f() != EnumC0668c.NULL) {
            return Float.valueOf((float) c0666a.mo1997k());
        }
        c0666a.mo1996j();
        return null;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo1948a(C0669d c0669d, Number number) throws IOException {
        if (number == null) {
            c0669d.mo2014f();
            return;
        }
        this.f1619a.m2152a(number.floatValue());
        c0669d.mo2005a(number);
    }
}
