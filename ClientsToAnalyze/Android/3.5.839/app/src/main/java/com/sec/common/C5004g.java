package com.sec.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;

/* compiled from: StrictModeWrapper.java */
/* renamed from: com.sec.common.g */
/* loaded from: classes.dex */
public class C5004g {

    /* renamed from: a */
    private static String f18257a = "StrictModeWrapper";

    @TargetApi(11)
    /* renamed from: a */
    public static void m18989a(Context context) {
        int i = context.getApplicationInfo().flags;
        if (Build.VERSION.SDK_INT >= 11 && (i & 2) == 2) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyFlashScreen().penaltyLog().build());
            C4996f.f18229a.m18893g(f18257a, "StrictMode is enabled");
        }
    }
}
