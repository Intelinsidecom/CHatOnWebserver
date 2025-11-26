package com.sec.chaton.util;

import android.content.SharedPreferences;
import android.os.Build;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: ChatONPref.java */
/* renamed from: com.sec.chaton.util.bs */
/* loaded from: classes.dex */
public class C1323bs {

    /* renamed from: a */
    private static final int f4543a = Build.VERSION.SDK_INT;

    /* renamed from: b */
    private static SharedPreferences f4544b = null;

    /* renamed from: a */
    public static SharedPreferences m4575a() {
        if (f4544b == null) {
            f4544b = GlobalApplication.m3100a().getSharedPreferences("ChatON", 0);
        }
        return f4544b;
    }

    /* renamed from: a */
    public static void m4579a(String str, String str2) {
        if (f4543a > 8) {
            m4575a().edit().putString(str, str2).apply();
        } else {
            m4575a().edit().putString(str, str2).commit();
        }
    }

    /* renamed from: a */
    public static void m4578a(String str, Long l) {
        if (f4543a > 8) {
            m4575a().edit().putLong(str, l.longValue()).apply();
        } else {
            m4575a().edit().putLong(str, l.longValue()).commit();
        }
    }

    /* renamed from: a */
    public static void m4576a(String str, Boolean bool) {
        if (f4543a > 8) {
            m4575a().edit().putBoolean(str, bool.booleanValue()).apply();
        } else {
            m4575a().edit().putBoolean(str, bool.booleanValue()).commit();
        }
    }

    /* renamed from: a */
    public static void m4577a(String str, Integer num) {
        if (f4543a > 8) {
            m4575a().edit().putInt(str, num.intValue()).apply();
        } else {
            m4575a().edit().putInt(str, num.intValue()).commit();
        }
    }
}
