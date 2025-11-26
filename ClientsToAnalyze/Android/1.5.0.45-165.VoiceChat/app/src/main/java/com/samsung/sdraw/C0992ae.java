package com.samsung.sdraw;

import android.util.Log;

/* renamed from: com.samsung.sdraw.ae */
/* loaded from: classes.dex */
class C0992ae {

    /* renamed from: a */
    private static final boolean[] f1440a = {false, false, true, true, true};

    /* renamed from: b */
    private static final int[] f1441b = {2, 3, 4, 5, 6};

    /* renamed from: a */
    public static void m1272a(String str) {
        m1270a(4, "SPen", str);
    }

    /* renamed from: a */
    public static void m1273a(String str, String str2, Object... objArr) {
        m1271a(4, str, str2, objArr);
    }

    /* renamed from: a */
    public static void m1270a(int i, String str, String str2) {
        if (f1440a[i]) {
            Log.println(f1441b[i], str, str2);
        }
    }

    /* renamed from: a */
    public static void m1271a(int i, String str, String str2, Object... objArr) {
        if (f1440a[i]) {
            Log.println(f1441b[i], str, String.format(str2, objArr));
        }
    }
}
