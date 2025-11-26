package com.facebook.p008b;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: Validate.java */
/* renamed from: com.facebook.b.t */
/* loaded from: classes.dex */
public final class C0106t {
    /* renamed from: a */
    public static void m277a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException("Argument " + str + " cannot be null");
        }
    }

    /* renamed from: a */
    public static <T> void m279a(Collection<T> collection, String str) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Container '" + str + "' cannot be empty");
        }
    }

    /* renamed from: b */
    public static <T> void m280b(Collection<T> collection, String str) {
        m277a((Object) collection, str);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            }
        }
    }

    /* renamed from: c */
    public static <T> void m281c(Collection<T> collection, String str) {
        m280b(collection, str);
        m279a((Collection) collection, str);
    }

    /* renamed from: a */
    public static void m278a(String str, String str2) {
        if (C0105s.m273a(str)) {
            throw new IllegalArgumentException("Argument " + str2 + " cannot be null or empty");
        }
    }
}
