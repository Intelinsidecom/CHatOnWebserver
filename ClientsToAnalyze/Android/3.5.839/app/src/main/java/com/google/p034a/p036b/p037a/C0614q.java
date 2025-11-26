package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.p038c.C0664a;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import java.lang.reflect.Field;

/* compiled from: ReflectiveTypeAdapterFactory.java */
/* renamed from: com.google.a.b.a.q */
/* loaded from: classes.dex */
class C0614q extends AbstractC0616s {

    /* renamed from: a */
    final AbstractC0562ae<?> f1420a;

    /* renamed from: b */
    final /* synthetic */ C0676j f1421b;

    /* renamed from: c */
    final /* synthetic */ C0664a f1422c;

    /* renamed from: d */
    final /* synthetic */ Field f1423d;

    /* renamed from: e */
    final /* synthetic */ boolean f1424e;

    /* renamed from: f */
    final /* synthetic */ C0613p f1425f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0614q(C0613p c0613p, String str, boolean z, boolean z2, C0676j c0676j, C0664a c0664a, Field field, boolean z3) {
        super(str, z, z2);
        this.f1425f = c0613p;
        this.f1421b = c0676j;
        this.f1422c = c0664a;
        this.f1423d = field;
        this.f1424e = z3;
        this.f1420a = this.f1421b.m2157a(this.f1422c);
    }

    @Override // com.google.p034a.p036b.p037a.AbstractC0616s
    /* renamed from: a */
    void mo2025a(C0669d c0669d, Object obj) throws IllegalAccessException, IllegalArgumentException {
        new C0621x(this.f1421b, this.f1420a, this.f1422c.m2104b()).mo1948a(c0669d, (C0669d) this.f1423d.get(obj));
    }

    @Override // com.google.p034a.p036b.p037a.AbstractC0616s
    /* renamed from: a */
    void mo2024a(C0666a c0666a, Object obj) throws IllegalAccessException, IllegalArgumentException {
        Object objMo1949b = this.f1420a.mo1949b(c0666a);
        if (objMo1949b != null || !this.f1424e) {
            this.f1423d.set(obj, objMo1949b);
        }
    }
}
