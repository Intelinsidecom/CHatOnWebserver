package com.facebook.p031a;

import android.content.Context;
import android.content.SharedPreferences;
import com.sec.common.util.C5033j;

/* compiled from: SessionStore.java */
/* renamed from: com.facebook.a.e */
/* loaded from: classes.dex */
public class C0429e {
    /* renamed from: a */
    public static void m1543a(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.clear();
        C5033j.m19087a(editorEdit);
    }

    /* renamed from: b */
    public static String m1545b(Context context) {
        return context.getSharedPreferences("facebook-session", 0).getString("user_real_name", null);
    }

    /* renamed from: a */
    public static boolean m1544a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.putString("user_real_name", str);
        C5033j.m19087a(editorEdit);
        return true;
    }

    /* renamed from: c */
    public static String m1547c(Context context) {
        return context.getSharedPreferences("facebook-session", 0).getString("user_name", null);
    }

    /* renamed from: b */
    public static boolean m1546b(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.putString("user_name", str);
        C5033j.m19087a(editorEdit);
        return true;
    }

    /* renamed from: d */
    public static String m1549d(Context context) {
        return context.getSharedPreferences("facebook-session", 0).getString("user_email", null);
    }

    /* renamed from: c */
    public static boolean m1548c(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.putString("user_email", str);
        C5033j.m19087a(editorEdit);
        return true;
    }

    /* renamed from: d */
    public static boolean m1550d(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.putString("user_profile", str);
        C5033j.m19087a(editorEdit);
        return true;
    }

    /* renamed from: e */
    public static String m1551e(Context context) {
        return context.getSharedPreferences("facebook-session", 0).getString("user_profile", null);
    }
}
