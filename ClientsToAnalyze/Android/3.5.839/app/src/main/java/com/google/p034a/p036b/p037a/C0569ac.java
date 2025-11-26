package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0558aa;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.ac */
/* loaded from: classes.dex */
final class C0569ac extends AbstractC0562ae<Character> {
    C0569ac() {
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Character mo1949b(C0666a c0666a) throws IOException {
        if (c0666a.mo1992f() == EnumC0668c.NULL) {
            c0666a.mo1996j();
            return null;
        }
        String strMo1994h = c0666a.mo1994h();
        if (strMo1994h.length() != 1) {
            throw new C0558aa("Expecting character, got: " + strMo1994h);
        }
        return Character.valueOf(strMo1994h.charAt(0));
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo1948a(C0669d c0669d, Character ch) throws IOException {
        c0669d.mo2010b(ch == null ? null : String.valueOf(ch));
    }
}
