package com.sec.common.util.log.collector;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.sec.common.C3330f;
import com.sec.common.CommonApplication;

/* compiled from: LogCollectorManager.java */
/* renamed from: com.sec.common.util.log.collector.c */
/* loaded from: classes.dex */
public class C3353c {

    /* renamed from: c */
    private static String f12100c;

    /* renamed from: b */
    private static final String f12099b = C3353c.class.getName();

    /* renamed from: a */
    public static Boolean f12098a = false;

    /* renamed from: a */
    public static boolean m11832a() {
        return CommonApplication.m11493l().getSharedPreferences("common_library_prefs", 0).getBoolean("log_collector_activated", false);
    }

    /* renamed from: a */
    public static void m11831a(String str) {
        f12100c = str;
    }

    /* renamed from: b */
    public static boolean m11833b() {
        return CommonApplication.m11493l().getSharedPreferences("common_library_prefs", 0).getInt("log_collector_enabled", 0) >= 15 && !f12098a.booleanValue();
    }

    /* renamed from: c */
    public static void m11834c() {
        int i = 0;
        PackageManager packageManager = CommonApplication.m11493l().getPackageManager();
        if (m11833b()) {
            try {
                i = packageManager.getPackageInfo("com.sec.spp.push", 0).versionCode;
                if (C3330f.f12033a.f11972b) {
                    C3330f.f12033a.m11654b(f12099b, "- ###writeWithParam - verName = " + i);
                }
            } catch (PackageManager.NameNotFoundException e) {
                m11830a(1);
            }
            m11830a(i);
        }
    }

    /* renamed from: a */
    static void m11830a(int i) {
        SharedPreferences.Editor editorEdit = CommonApplication.m11493l().getSharedPreferences("common_library_prefs", 0).edit();
        editorEdit.putInt("log_collector_enabled", i);
        editorEdit.commit();
    }

    /* renamed from: d */
    public static void m11835d() {
        C3351a.m11818a();
        C3351a.m11821b();
    }
}
