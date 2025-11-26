package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.C0676j;
import com.google.p034a.InterfaceC0563af;
import com.google.p034a.InterfaceC0675i;
import com.google.p034a.p035a.InterfaceC0555b;
import com.google.p034a.p036b.C0629af;
import com.google.p034a.p036b.C0639b;
import com.google.p034a.p036b.C0643f;
import com.google.p034a.p036b.C0656s;
import com.google.p034a.p038c.C0664a;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory.java */
/* renamed from: com.google.a.b.a.p */
/* loaded from: classes.dex */
public final class C0613p implements InterfaceC0563af {

    /* renamed from: a */
    private final C0643f f1417a;

    /* renamed from: b */
    private final InterfaceC0675i f1418b;

    /* renamed from: c */
    private final C0656s f1419c;

    public C0613p(C0643f c0643f, InterfaceC0675i interfaceC0675i, C0656s c0656s) {
        this.f1417a = c0643f;
        this.f1418b = interfaceC0675i;
        this.f1419c = c0656s;
    }

    /* renamed from: a */
    public boolean m2023a(Field field, boolean z) {
        return (this.f1419c.m2079a(field.getType(), z) || this.f1419c.m2080a(field, z)) ? false : true;
    }

    /* renamed from: a */
    private String m2021a(Field field) {
        InterfaceC0555b interfaceC0555b = (InterfaceC0555b) field.getAnnotation(InterfaceC0555b.class);
        return interfaceC0555b == null ? this.f1418b.mo2105a(field) : interfaceC0555b.m1944a();
    }

    @Override // com.google.p034a.InterfaceC0563af
    /* renamed from: a */
    public <T> AbstractC0562ae<T> mo1950a(C0676j c0676j, C0664a<T> c0664a) {
        C0614q c0614q = null;
        Class<? super T> clsM2103a = c0664a.m2103a();
        if (Object.class.isAssignableFrom(clsM2103a)) {
            return new C0615r(this.f1417a.m2071a(c0664a), m2022a(c0676j, c0664a, clsM2103a), c0614q);
        }
        return null;
    }

    /* renamed from: a */
    private AbstractC0616s m2020a(C0676j c0676j, Field field, String str, C0664a<?> c0664a, boolean z, boolean z2) {
        return new C0614q(this, str, z, z2, c0676j, c0664a, field, C0629af.m2041a((Type) c0664a.m2103a()));
    }

    /* renamed from: a */
    private Map<String, AbstractC0616s> m2022a(C0676j c0676j, C0664a<?> c0664a, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type typeM2104b = c0664a.m2104b();
        while (cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                boolean zM2023a = m2023a(field, true);
                boolean zM2023a2 = m2023a(field, false);
                if (zM2023a || zM2023a2) {
                    field.setAccessible(true);
                    AbstractC0616s abstractC0616sM2020a = m2020a(c0676j, field, m2021a(field), C0664a.m2100a(C0639b.m2053a(c0664a.m2104b(), cls, field.getGenericType())), zM2023a, zM2023a2);
                    AbstractC0616s abstractC0616s = (AbstractC0616s) linkedHashMap.put(abstractC0616sM2020a.f1428g, abstractC0616sM2020a);
                    if (abstractC0616s != null) {
                        throw new IllegalArgumentException(typeM2104b + " declares multiple JSON fields named " + abstractC0616s.f1428g);
                    }
                }
            }
            c0664a = C0664a.m2100a(C0639b.m2053a(c0664a.m2104b(), cls, cls.getGenericSuperclass()));
            cls = c0664a.m2103a();
        }
        return linkedHashMap;
    }
}
