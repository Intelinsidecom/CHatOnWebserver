package com.facebook.p032b;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: Validate.java */
/* renamed from: com.facebook.b.t */
/* loaded from: classes.dex */
public final class C0477t {
    /* renamed from: a */
    public static void m1721a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException("Argument " + str + " cannot be null");
        }
    }

    /* renamed from: a */
    public static <T> void m1723a(Collection<T> collection, String str) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Container '" + str + "' cannot be empty");
        }
    }

    /* renamed from: b */
    public static <T> void m1724b(Collection<T> collection, String str) {
        m1721a((Object) collection, str);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            }
        }
    }

    /* renamed from: c */
    public static <T> void m1725c(Collection<T> collection, String str) {
        m1724b(collection, str);
        m1723a((Collection) collection, str);
    }

    /* renamed from: a */
    public static void m1722a(String str, String str2) {
        if (C0476s.m1717a(str)) {
            throw new IllegalArgumentException("Argument " + str2 + " cannot be null or empty");
        }
    }
}
