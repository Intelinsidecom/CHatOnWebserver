package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p038c.C0664a;
import java.util.Date;

/* compiled from: DateTypeAdapter.java */
/* renamed from: com.google.a.b.a.f */
/* loaded from: classes.dex */
final class C0603f implements InterfaceC0563af {
    C0603f() {
    }

    @Override // com.google.p034a.InterfaceC0563af
    /* renamed from: a */
    public <T> AbstractC0562ae<T> mo1950a(C0676j c0676j, C0664a<T> c0664a) {
        if (c0664a.m2103a() == Date.class) {
            return new C0602e();
        }
        return null;
    }
}
