package com.google.p034a;

import java.lang.reflect.Field;

/* compiled from: FieldNamingPolicy.java */
/* renamed from: com.google.a.d */
/* loaded from: classes.dex */
enum C0665d extends EnumC0663c {
    C0665d(String str, int i) {
        super(str, i, null);
    }

    @Override // com.google.p034a.InterfaceC0675i
    /* renamed from: a */
    public String mo2105a(Field field) {
        return field.getName();
    }
}
