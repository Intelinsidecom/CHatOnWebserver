package com.google.p034a.p036b;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Primitives.java */
/* renamed from: com.google.a.b.af */
/* loaded from: classes.dex */
public final class C0629af {

    /* renamed from: a */
    private static final Map<Class<?>, Class<?>> f1496a;

    /* renamed from: b */
    private static final Map<Class<?>, Class<?>> f1497b;

    static {
        HashMap map = new HashMap(16);
        HashMap map2 = new HashMap(16);
        m2040a(map, map2, Boolean.TYPE, Boolean.class);
        m2040a(map, map2, Byte.TYPE, Byte.class);
        m2040a(map, map2, Character.TYPE, Character.class);
        m2040a(map, map2, Double.TYPE, Double.class);
        m2040a(map, map2, Float.TYPE, Float.class);
        m2040a(map, map2, Integer.TYPE, Integer.class);
        m2040a(map, map2, Long.TYPE, Long.class);
        m2040a(map, map2, Short.TYPE, Short.class);
        m2040a(map, map2, Void.TYPE, Void.class);
        f1496a = Collections.unmodifiableMap(map);
        f1497b = Collections.unmodifiableMap(map2);
    }

    /* renamed from: a */
    private static void m2040a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    /* renamed from: a */
    public static boolean m2041a(Type type) {
        return f1496a.containsKey(type);
    }

    /* renamed from: a */
    public static <T> Class<T> m2039a(Class<T> cls) {
        Class<T> cls2 = (Class) f1496a.get(C0565a.m1951a(cls));
        return cls2 == null ? cls : cls2;
    }
}
