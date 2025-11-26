package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p038c.C0664a;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.an */
/* loaded from: classes.dex */
final class C0580an implements InterfaceC0563af {
    C0580an() {
    }

    @Override // com.google.p034a.InterfaceC0563af
    /* renamed from: a */
    public <T> AbstractC0562ae<T> mo1950a(C0676j c0676j, C0664a<T> c0664a) {
        if (c0664a.m2103a() != Timestamp.class) {
            return null;
        }
        return new C0581ao(this, c0676j.m2158a((Class) Date.class));
    }
}
