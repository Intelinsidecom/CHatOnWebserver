package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;
import java.net.URL;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.ai */
/* loaded from: classes.dex */
final class C0575ai extends AbstractC0562ae<URL> {
    C0575ai() {
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public URL mo1949b(C0666a c0666a) throws IOException {
        if (c0666a.mo1992f() == EnumC0668c.NULL) {
            c0666a.mo1996j();
            return null;
        }
        String strMo1994h = c0666a.mo1994h();
        if ("null".equals(strMo1994h)) {
            return null;
        }
        return new URL(strMo1994h);
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo1948a(C0669d c0669d, URL url) throws IOException {
        c0669d.mo2010b(url == null ? null : url.toExternalForm());
    }
}
