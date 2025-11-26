package com.sec.chaton.p020c;

import android.text.TextUtils;
import com.sec.chaton.util.C3171am;

/* compiled from: NetworkConstant.java */
/* renamed from: com.sec.chaton.c.g */
/* loaded from: classes.dex */
public final class C0822g {

    /* renamed from: a */
    private static String f3151a;

    /* renamed from: a */
    public static void m4372a(String str, Integer num, Integer num2, Integer num3, Integer num4) {
        f3151a = str;
        C0817b.f3131c.put("XXX", Integer.valueOf(num.intValue() * 1000));
        C0817b.f3132d.put("XXX", Integer.valueOf(num2.intValue() * 1000));
        C0817b.f3133e.put("XXX", Integer.valueOf(num3.intValue() * 1000));
        C0817b.f3134f.put("XXX", Integer.valueOf(num4.intValue() * 1000));
    }

    /* renamed from: a */
    public static void m4371a() {
        f3151a = "";
    }

    /* renamed from: b */
    public static int m4373b() {
        if (!TextUtils.isEmpty(f3151a)) {
            return C0817b.f3131c.get("XXX").intValue();
        }
        if (C0817b.f3131c.containsKey(C3171am.m11064f())) {
            return C0817b.f3131c.get(C3171am.m11064f()).intValue();
        }
        return 20000;
    }

    /* renamed from: c */
    public static int m4374c() {
        if (!TextUtils.isEmpty(f3151a)) {
            return C0817b.f3132d.get("XXX").intValue();
        }
        if (C0817b.f3132d.containsKey(C3171am.m11064f())) {
            return C0817b.f3132d.get(C3171am.m11064f()).intValue();
        }
        return 30000;
    }

    /* renamed from: d */
    public static int m4375d() {
        if (!TextUtils.isEmpty(f3151a)) {
            return C0817b.f3133e.get("XXX").intValue();
        }
        if (C0817b.f3133e.containsKey(C3171am.m11064f())) {
            return C0817b.f3133e.get(C3171am.m11064f()).intValue();
        }
        return 20000;
    }

    /* renamed from: e */
    public static int m4376e() {
        if (!TextUtils.isEmpty(f3151a)) {
            return C0817b.f3134f.get("XXX").intValue();
        }
        if (C0817b.f3134f.containsKey(C3171am.m11064f())) {
            return C0817b.f3134f.get(C3171am.m11064f()).intValue();
        }
        return 30000;
    }
}
