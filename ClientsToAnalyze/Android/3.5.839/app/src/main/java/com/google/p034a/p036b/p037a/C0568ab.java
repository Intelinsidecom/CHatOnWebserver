package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0558aa;
import com.google.p034a.p036b.C0659v;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.ab */
/* loaded from: classes.dex */
final class C0568ab extends AbstractC0562ae<Number> {
    C0568ab() {
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Number mo1949b(C0666a c0666a) throws IOException {
        EnumC0668c enumC0668cMo1992f = c0666a.mo1992f();
        switch (enumC0668cMo1992f) {
            case NUMBER:
                return new C0659v(c0666a.mo1994h());
            case BOOLEAN:
            case STRING:
            default:
                throw new C0558aa("Expecting number, got: " + enumC0668cMo1992f);
            case NULL:
                c0666a.mo1996j();
                return null;
        }
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo1948a(C0669d c0669d, Number number) throws IOException {
        c0669d.mo2005a(number);
    }
}
