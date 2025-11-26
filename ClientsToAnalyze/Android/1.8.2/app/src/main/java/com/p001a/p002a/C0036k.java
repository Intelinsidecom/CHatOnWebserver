package com.p001a.p002a;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SessionStore.java */
/* renamed from: com.a.a.k */
/* loaded from: classes.dex */
public class C0036k {
    /* renamed from: a */
    public static boolean m31a(C0027b c0027b, Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.putString("access_token", c0027b.m16b());
        editorEdit.putLong("expires_in", c0027b.m18c());
        return editorEdit.commit();
    }

    /* renamed from: b */
    public static boolean m34b(C0027b c0027b, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("facebook-session", 0);
        c0027b.m14a(sharedPreferences.getString("access_token", null));
        c0027b.m9a(sharedPreferences.getLong("expires_in", 0L));
        return c0027b.m15a();
    }

    /* renamed from: a */
    public static void m29a(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    /* renamed from: b */
    public static String m32b(Context context) {
        return context.getSharedPreferences("facebook-session", 0).getString("user_name", null);
    }

    /* renamed from: a */
    public static boolean m30a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.putString("user_name", str);
        return editorEdit.commit();
    }

    /* renamed from: c */
    public static String m35c(Context context) {
        return context.getSharedPreferences("facebook-session", 0).getString("user_email", null);
    }

    /* renamed from: b */
    public static boolean m33b(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.putString("user_email", str);
        return editorEdit.commit();
    }
}
