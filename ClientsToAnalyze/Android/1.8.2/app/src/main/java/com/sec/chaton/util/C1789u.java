package com.sec.chaton.util;

import android.content.SharedPreferences;
import android.os.Build;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: ChatONPref.java */
/* renamed from: com.sec.chaton.util.u */
/* loaded from: classes.dex */
public class C1789u {

    /* renamed from: a */
    private static final int f6462a = Build.VERSION.SDK_INT;

    /* renamed from: b */
    private static SharedPreferences f6463b = null;

    /* renamed from: a */
    public static SharedPreferences m6075a() {
        if (f6463b == null) {
            f6463b = GlobalApplication.m3260b().getSharedPreferences("ChatON", 0);
        }
        return f6463b;
    }

    /* renamed from: a */
    public static void m6079a(String str, String str2) {
        if (f6462a > 8) {
            m6075a().edit().putString(str, str2).apply();
        } else {
            m6075a().edit().putString(str, str2).commit();
        }
    }

    /* renamed from: a */
    public static void m6078a(String str, Long l) {
        if (f6462a > 8) {
            m6075a().edit().putLong(str, l.longValue()).apply();
        } else {
            m6075a().edit().putLong(str, l.longValue()).commit();
        }
    }

    /* renamed from: a */
    public static void m6076a(String str, Boolean bool) {
        if (f6462a > 8) {
            m6075a().edit().putBoolean(str, bool.booleanValue()).apply();
        } else {
            m6075a().edit().putBoolean(str, bool.booleanValue()).commit();
        }
    }

    /* renamed from: a */
    public static void m6077a(String str, Integer num) {
        if (f6462a > 8) {
            m6075a().edit().putInt(str, num.intValue()).apply();
        } else {
            m6075a().edit().putInt(str, num.intValue()).commit();
        }
    }
}
