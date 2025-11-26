package com.facebook.p007a;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SessionStore.java */
/* renamed from: com.facebook.a.e */
/* loaded from: classes.dex */
public class C0058e {
    /* renamed from: a */
    public static void m100a(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    /* renamed from: b */
    public static String m102b(Context context) {
        return context.getSharedPreferences("facebook-session", 0).getString("user_real_name", null);
    }

    /* renamed from: a */
    public static boolean m101a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.putString("user_real_name", str);
        return editorEdit.commit();
    }

    /* renamed from: c */
    public static String m104c(Context context) {
        return context.getSharedPreferences("facebook-session", 0).getString("user_name", null);
    }

    /* renamed from: b */
    public static boolean m103b(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.putString("user_name", str);
        return editorEdit.commit();
    }

    /* renamed from: d */
    public static String m106d(Context context) {
        return context.getSharedPreferences("facebook-session", 0).getString("user_email", null);
    }

    /* renamed from: c */
    public static boolean m105c(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.putString("user_email", str);
        return editorEdit.commit();
    }

    /* renamed from: d */
    public static boolean m107d(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.putString("user_profile", str);
        return editorEdit.commit();
    }

    /* renamed from: e */
    public static String m108e(Context context) {
        return context.getSharedPreferences("facebook-session", 0).getString("user_profile", null);
    }
}
