package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.p038c.C0664a;
import java.sql.Time;

/* compiled from: TimeTypeAdapter.java */
/* renamed from: com.google.a.b.a.w */
/* loaded from: classes.dex */
final class C0620w implements InterfaceC0563af {
    C0620w() {
    }

    @Override // com.google.p034a.InterfaceC0563af
    /* renamed from: a */
    public <T> AbstractC0562ae<T> mo1950a(C0676j c0676j, C0664a<T> c0664a) {
        if (c0664a.m2103a() == Time.class) {
            return new C0619v();
        }
        return null;
    }
}
