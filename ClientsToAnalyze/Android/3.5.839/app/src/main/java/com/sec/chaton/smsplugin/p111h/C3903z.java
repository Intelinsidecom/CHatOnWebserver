package com.sec.chaton.smsplugin.p111h;

import java.util.HashMap;

/* compiled from: SendingProgressTokenManager.java */
/* renamed from: com.sec.chaton.smsplugin.h.z */
/* loaded from: classes.dex */
public class C3903z {

    /* renamed from: a */
    private static final HashMap<Object, Long> f14021a = new HashMap<>();

    /* renamed from: a */
    public static synchronized long m15073a(Object obj) {
        Long l;
        l = f14021a.get(obj);
        return l != null ? l.longValue() : -1L;
    }

    /* renamed from: a */
    public static synchronized void m15074a(Object obj, long j) {
        f14021a.put(obj, Long.valueOf(j));
    }

    /* renamed from: b */
    public static synchronized void m15075b(Object obj) {
        f14021a.remove(obj);
    }
}
