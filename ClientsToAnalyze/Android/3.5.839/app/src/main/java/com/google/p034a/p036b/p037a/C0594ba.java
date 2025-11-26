package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0558aa;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.ba */
/* loaded from: classes.dex */
final class C0594ba extends AbstractC0562ae<Number> {
    C0594ba() {
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Number mo1949b(C0666a c0666a) throws IOException {
        if (c0666a.mo1992f() == EnumC0668c.NULL) {
            c0666a.mo1996j();
            return null;
        }
        try {
            return Byte.valueOf((byte) c0666a.mo1999m());
        } catch (NumberFormatException e) {
            throw new C0558aa(e);
        }
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo1948a(C0669d c0669d, Number number) throws IOException {
        c0669d.mo2005a(number);
    }
}
