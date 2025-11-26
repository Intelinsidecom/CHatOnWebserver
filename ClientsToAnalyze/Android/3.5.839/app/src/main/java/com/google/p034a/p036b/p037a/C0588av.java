package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.av */
/* loaded from: classes.dex */
final class C0588av extends AbstractC0562ae<Boolean> {
    C0588av() {
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean mo1949b(C0666a c0666a) throws IOException {
        if (c0666a.mo1992f() == EnumC0668c.NULL) {
            c0666a.mo1996j();
            return null;
        }
        if (c0666a.mo1992f() == EnumC0668c.STRING) {
            return Boolean.valueOf(Boolean.parseBoolean(c0666a.mo1994h()));
        }
        return Boolean.valueOf(c0666a.mo1995i());
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo1948a(C0669d c0669d, Boolean bool) throws IOException {
        if (bool == null) {
            c0669d.mo2014f();
        } else {
            c0669d.mo2007a(bool.booleanValue());
        }
    }
}
