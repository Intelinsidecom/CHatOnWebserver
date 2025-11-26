package com.sec.chaton.push.registration;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class RegistrationManager {
    /* renamed from: a */
    public static synchronized void m3010a(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.sec.chaton.push.config", 0).edit();
        editorEdit.remove("appId");
        editorEdit.commit();
    }

    /* renamed from: a */
    public static synchronized void m3011a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.sec.chaton.push.config", 0).edit();
        editorEdit.putString("appId", str);
        editorEdit.commit();
    }

    /* renamed from: b */
    public static String m3012b(Context context) {
        return context.getSharedPreferences("com.sec.chaton.push.config", 0).getString("appId", null);
    }

    /* renamed from: b */
    public static void m3013b(Context context, String str) {
        synchronized (RegistrationManager.class) {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.sec.chaton.push.config", 0).edit();
            editorEdit.putString("regId", str);
            editorEdit.commit();
        }
    }

    /* renamed from: c */
    public static void m3014c(Context context) {
        synchronized (RegistrationManager.class) {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.sec.chaton.push.config", 0).edit();
            editorEdit.remove("regId");
            editorEdit.commit();
        }
    }

    /* renamed from: d */
    public static String m3015d(Context context) {
        return context.getSharedPreferences("com.sec.chaton.push.config", 0).getString("regId", null);
    }
}
