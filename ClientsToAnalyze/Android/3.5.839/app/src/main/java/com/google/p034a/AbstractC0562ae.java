package com.google.p034a;

import com.google.p034a.p036b.p037a.C0606i;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import java.io.IOException;

/* compiled from: TypeAdapter.java */
/* renamed from: com.google.a.ae */
/* loaded from: classes.dex */
public abstract class AbstractC0562ae<T> {
    /* renamed from: a */
    public abstract void mo1948a(C0669d c0669d, T t);

    /* renamed from: b */
    public abstract T mo1949b(C0666a c0666a);

    /* renamed from: a */
    public final AbstractC0686t m1947a(T t) {
        try {
            C0606i c0606i = new C0606i();
            mo1948a(c0606i, t);
            return c0606i.m2008a();
        } catch (IOException e) {
            throw new C0687u(e);
        }
    }
}
