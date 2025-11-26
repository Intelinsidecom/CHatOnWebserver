package com.sec.chaton.util;

import android.content.SharedPreferences;
import android.os.Build;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class ChatONPref {

    /* renamed from: a */
    private static final int f3633a = Build.VERSION.SDK_INT;

    /* renamed from: b */
    private static SharedPreferences f3634b = null;

    /* renamed from: a */
    public static SharedPreferences m3519a() {
        if (f3634b == null) {
            f3634b = GlobalApplication.m2387e().getSharedPreferences("ChatON", 0);
        }
        return f3634b;
    }

    /* renamed from: a */
    public static void m3520a(String str, Boolean bool) {
        if (f3633a > 8) {
            m3519a().edit().putBoolean(str, bool.booleanValue()).apply();
        } else {
            m3519a().edit().putBoolean(str, bool.booleanValue()).commit();
        }
    }

    /* renamed from: a */
    public static void m3521a(String str, Integer num) {
        if (f3633a > 8) {
            m3519a().edit().putInt(str, num.intValue()).apply();
        } else {
            m3519a().edit().putInt(str, num.intValue()).commit();
        }
    }

    /* renamed from: a */
    public static void m3522a(String str, Long l) {
        if (f3633a > 8) {
            m3519a().edit().putLong(str, l.longValue()).apply();
        } else {
            m3519a().edit().putLong(str, l.longValue()).commit();
        }
    }

    /* renamed from: a */
    public static void m3523a(String str, String str2) {
        if (f3633a > 8) {
            m3519a().edit().putString(str, str2).apply();
        } else {
            m3519a().edit().putString(str, str2).commit();
        }
    }
}
