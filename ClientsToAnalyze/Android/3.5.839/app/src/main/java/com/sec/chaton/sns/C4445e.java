package com.sec.chaton.sns;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.sec.common.util.C5033j;
import p021c.C0349h;
import p021c.p022a.C0326a;

/* compiled from: WeiboSessionStore.java */
/* renamed from: com.sec.chaton.sns.e */
/* loaded from: classes.dex */
public class C4445e {
    /* renamed from: a */
    public static boolean m16840a(C0326a c0326a, Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("weibo-session", 0).edit();
        editorEdit.putString("access_token", c0326a.mo1123d());
        editorEdit.putString("secret_token", c0326a.mo1122c());
        C5033j.m19087a(editorEdit);
        return true;
    }

    /* renamed from: a */
    public static boolean m16841a(C0349h c0349h, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("weibo-session", 0);
        try {
            c0349h.m1229a("1549470309", "a7d96376036a4b35a3e7a1e24632bd88");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        if (m16842b(context)) {
            c0349h.m1228a(new C0326a(sharedPreferences.getString("access_token", ""), sharedPreferences.getString("secret_token", "")));
            return true;
        }
        return true;
    }

    /* renamed from: a */
    public static void m16838a(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("weibo-session", 0).edit();
        editorEdit.clear();
        C5033j.m19087a(editorEdit);
    }

    /* renamed from: b */
    public static boolean m16842b(Context context) {
        return context.getSharedPreferences("weibo-session", 0).getString("secret_token", null) != null;
    }

    /* renamed from: c */
    public static String m16844c(Context context) {
        return context.getSharedPreferences("weibo-session", 0).getString("user_name", null);
    }

    /* renamed from: a */
    public static boolean m16839a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("weibo-session", 0).edit();
        editorEdit.putString("user_name", str);
        C5033j.m19087a(editorEdit);
        return true;
    }

    /* renamed from: d */
    public static String m16846d(Context context) {
        return context.getSharedPreferences("weibo-session", 0).getString("user_id", null);
    }

    /* renamed from: b */
    public static boolean m16843b(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("weibo-session", 0).edit();
        editorEdit.putString("user_id", str);
        C5033j.m19087a(editorEdit);
        return true;
    }

    /* renamed from: e */
    public static String m16848e(Context context) {
        return context.getSharedPreferences("weibo-session", 0).getString("user_profile", null);
    }

    /* renamed from: c */
    public static boolean m16845c(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("weibo-session", 0).edit();
        editorEdit.putString("user_profile", str);
        C5033j.m19087a(editorEdit);
        return true;
    }

    /* renamed from: d */
    public static boolean m16847d(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("weibo-session", 0).edit();
        editorEdit.putString("2.0_access_token", str);
        C5033j.m19087a(editorEdit);
        return true;
    }

    /* renamed from: f */
    public static String m16849f(Context context) {
        return context.getSharedPreferences("weibo-session", 0).getString("2.0_access_token", null);
    }
}
