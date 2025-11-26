package com.google.p034a.p036b;

import com.google.p034a.AbstractC0686t;
import com.google.p034a.p036b.p037a.C0622y;
import com.google.p034a.p039d.C0669d;
import java.io.Writer;

/* compiled from: Streams.java */
/* renamed from: com.google.a.b.ag */
/* loaded from: classes.dex */
public final class C0630ag {
    /* renamed from: a */
    public static void m2043a(AbstractC0686t abstractC0686t, C0669d c0669d) {
        C0622y.f1453P.mo1948a(c0669d, abstractC0686t);
    }

    /* renamed from: a */
    public static Writer m2042a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new C0632ai(appendable);
    }
}
