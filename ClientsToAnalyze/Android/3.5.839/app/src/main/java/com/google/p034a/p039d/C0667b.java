package com.google.p034a.p039d;

import com.google.p034a.p036b.AbstractC0658u;
import com.google.p034a.p036b.p037a.C0604g;
import java.io.IOException;

/* compiled from: JsonReader.java */
/* renamed from: com.google.a.d.b */
/* loaded from: classes.dex */
final class C0667b extends AbstractC0658u {
    C0667b() {
    }

    @Override // com.google.p034a.p036b.AbstractC0658u
    /* renamed from: a */
    public void mo2082a(C0666a c0666a) throws IOException {
        if (!(c0666a instanceof C0604g)) {
            int iM2119o = c0666a.f1578i;
            if (iM2119o == 0) {
                iM2119o = c0666a.m2119o();
            }
            if (iM2119o == 13) {
                c0666a.f1578i = 9;
                return;
            } else if (iM2119o == 12) {
                c0666a.f1578i = 8;
                return;
            } else {
                if (iM2119o == 14) {
                    c0666a.f1578i = 10;
                    return;
                }
                throw new IllegalStateException("Expected a name but was " + c0666a.mo1992f() + "  at line " + c0666a.m2124u() + " column " + c0666a.m2125v());
            }
        }
        ((C0604g) c0666a).m2001o();
    }
}
