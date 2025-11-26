package com.sec.common.util;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;

/* compiled from: CompatUtils.java */
/* renamed from: com.sec.common.util.j */
/* loaded from: classes.dex */
public class C5033j {
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m19087a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }
}
