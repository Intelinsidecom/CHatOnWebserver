package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0558aa;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;
import java.util.BitSet;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.ak */
/* loaded from: classes.dex */
final class C0577ak extends AbstractC0562ae<BitSet> {
    C0577ak() {
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BitSet mo1949b(C0666a c0666a) throws IOException {
        boolean zMo1995i;
        if (c0666a.mo1992f() == EnumC0668c.NULL) {
            c0666a.mo1996j();
            return null;
        }
        BitSet bitSet = new BitSet();
        c0666a.mo1987a();
        EnumC0668c enumC0668cMo1992f = c0666a.mo1992f();
        int i = 0;
        while (enumC0668cMo1992f != EnumC0668c.END_ARRAY) {
            switch (enumC0668cMo1992f) {
                case NUMBER:
                    if (c0666a.mo1999m() == 0) {
                        zMo1995i = false;
                        break;
                    } else {
                        zMo1995i = true;
                        break;
                    }
                case BOOLEAN:
                    zMo1995i = c0666a.mo1995i();
                    break;
                case STRING:
                    String strMo1994h = c0666a.mo1994h();
                    try {
                        if (Integer.parseInt(strMo1994h) == 0) {
                            zMo1995i = false;
                            break;
                        } else {
                            zMo1995i = true;
                            break;
                        }
                    } catch (NumberFormatException e) {
                        throw new C0558aa("Error: Expecting: bitset number value (1, 0), Found: " + strMo1994h);
                    }
                default:
                    throw new C0558aa("Invalid bitset value type: " + enumC0668cMo1992f);
            }
            if (zMo1995i) {
                bitSet.set(i);
            }
            i++;
            enumC0668cMo1992f = c0666a.mo1992f();
        }
        c0666a.mo1988b();
        return bitSet;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo1948a(C0669d c0669d, BitSet bitSet) throws IOException {
        if (bitSet == null) {
            c0669d.mo2014f();
            return;
        }
        c0669d.mo2009b();
        for (int i = 0; i < bitSet.length(); i++) {
            c0669d.mo2004a(bitSet.get(i) ? 1 : 0);
        }
        c0669d.mo2011c();
    }
}
