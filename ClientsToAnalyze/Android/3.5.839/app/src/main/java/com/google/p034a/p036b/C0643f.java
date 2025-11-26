package com.google.p034a.p036b;

import com.google.p034a.InterfaceC0683q;
import com.google.p034a.p038c.C0664a;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: ConstructorConstructor.java */
/* renamed from: com.google.a.b.f */
/* loaded from: classes.dex */
public final class C0643f {

    /* renamed from: a */
    private final Map<Type, InterfaceC0683q<?>> f1513a;

    public C0643f(Map<Type, InterfaceC0683q<?>> map) {
        this.f1513a = map;
    }

    /* renamed from: a */
    public <T> InterfaceC0628ae<T> m2071a(C0664a<T> c0664a) throws NoSuchMethodException, SecurityException {
        Type typeM2104b = c0664a.m2104b();
        Class<? super T> clsM2103a = c0664a.m2103a();
        InterfaceC0683q<?> interfaceC0683q = this.f1513a.get(typeM2104b);
        if (interfaceC0683q != null) {
            return new C0644g(this, interfaceC0683q, typeM2104b);
        }
        InterfaceC0683q<?> interfaceC0683q2 = this.f1513a.get(clsM2103a);
        if (interfaceC0683q2 != null) {
            return new C0648k(this, interfaceC0683q2, typeM2104b);
        }
        InterfaceC0628ae<T> interfaceC0628aeM2068a = m2068a(clsM2103a);
        if (interfaceC0628aeM2068a == null) {
            InterfaceC0628ae<T> interfaceC0628aeM2069a = m2069a(typeM2104b, clsM2103a);
            return interfaceC0628aeM2069a == null ? m2070b(typeM2104b, clsM2103a) : interfaceC0628aeM2069a;
        }
        return interfaceC0628aeM2068a;
    }

    /* renamed from: a */
    private <T> InterfaceC0628ae<T> m2068a(Class<? super T> cls) throws NoSuchMethodException, SecurityException {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new C0649l(this, declaredConstructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /* renamed from: a */
    private <T> InterfaceC0628ae<T> m2069a(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new C0650m(this);
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new C0651n(this, type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new C0652o(this);
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new C0653p(this);
            }
            return new C0654q(this);
        }
        if (Map.class.isAssignableFrom(cls)) {
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new C0655r(this);
            }
            if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(C0664a.m2100a(((ParameterizedType) type).getActualTypeArguments()[0]).m2103a())) {
                return new C0645h(this);
            }
            return new C0646i(this);
        }
        return null;
    }

    /* renamed from: b */
    private <T> InterfaceC0628ae<T> m2070b(Type type, Class<? super T> cls) {
        return new C0647j(this, cls, type);
    }

    public String toString() {
        return this.f1513a.toString();
    }
}
