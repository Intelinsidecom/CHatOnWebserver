package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p038c.C0664a;
import java.sql.Date;

/* compiled from: SqlDateTypeAdapter.java */
/* renamed from: com.google.a.b.a.u */
/* loaded from: classes.dex */
final class C0618u implements InterfaceC0563af {
    C0618u() {
    }

    @Override // com.google.p034a.InterfaceC0563af
    /* renamed from: a */
    public <T> AbstractC0562ae<T> mo1950a(C0676j c0676j, C0664a<T> c0664a) {
        if (c0664a.m2103a() == Date.class) {
            return new C0617t();
        }
        return null;
    }
}
