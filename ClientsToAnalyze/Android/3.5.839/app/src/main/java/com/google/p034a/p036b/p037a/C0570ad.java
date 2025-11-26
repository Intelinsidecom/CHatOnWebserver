package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.ad */
/* loaded from: classes.dex */
final class C0570ad extends AbstractC0562ae<String> {
    C0570ad() {
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String mo1949b(C0666a c0666a) throws IOException {
        EnumC0668c enumC0668cMo1992f = c0666a.mo1992f();
        if (enumC0668cMo1992f == EnumC0668c.NULL) {
            c0666a.mo1996j();
            return null;
        }
        if (enumC0668cMo1992f == EnumC0668c.BOOLEAN) {
            return Boolean.toString(c0666a.mo1995i());
        }
        return c0666a.mo1994h();
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo1948a(C0669d c0669d, String str) throws IOException {
        c0669d.mo2010b(str);
    }
}
