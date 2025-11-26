package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0558aa;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;
import java.math.BigInteger;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.af */
/* loaded from: classes.dex */
final class C0572af extends AbstractC0562ae<BigInteger> {
    C0572af() {
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BigInteger mo1949b(C0666a c0666a) throws IOException {
        if (c0666a.mo1992f() == EnumC0668c.NULL) {
            c0666a.mo1996j();
            return null;
        }
        try {
            return new BigInteger(c0666a.mo1994h());
        } catch (NumberFormatException e) {
            throw new C0558aa(e);
        }
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo1948a(C0669d c0669d, BigInteger bigInteger) throws IOException {
        c0669d.mo2005a(bigInteger);
    }
}
