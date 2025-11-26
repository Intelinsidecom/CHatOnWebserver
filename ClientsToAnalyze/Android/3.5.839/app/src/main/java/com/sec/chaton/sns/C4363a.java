package com.sec.chaton.sns;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.sec.common.util.C5033j;

/* compiled from: OdnoklassnikiSessionStore.java */
/* renamed from: com.sec.chaton.sns.a */
/* loaded from: classes.dex */
public class C4363a {
    /* renamed from: a */
    public static final void m16548a(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = m16553d(context).edit();
        editorEdit.putString("od_access_token", str);
        editorEdit.putString("od_refresh_token", str2);
        C5033j.m19087a(editorEdit);
    }

    /* renamed from: a */
    public static final void m16547a(Context context, String str) {
        SharedPreferences.Editor editorEdit = m16553d(context).edit();
        editorEdit.putString("od_access_token", str);
        C5033j.m19087a(editorEdit);
    }

    /* renamed from: b */
    public static final void m16550b(Context context, String str) {
        SharedPreferences.Editor editorEdit = m16553d(context).edit();
        editorEdit.putString("od_refresh_token", str);
        C5033j.m19087a(editorEdit);
    }

    /* renamed from: a */
    public static final void m16546a(Context context) {
        SharedPreferences.Editor editorEdit = m16553d(context).edit();
        editorEdit.remove("od_access_token");
        editorEdit.remove("od_refresh_token");
        C5033j.m19087a(editorEdit);
    }

    /* renamed from: b */
    public static final String m16549b(Context context) {
        return m16553d(context).getString("od_access_token", null);
    }

    /* renamed from: c */
    public static final String m16551c(Context context) {
        return m16553d(context).getString("od_refresh_token", null);
    }

    /* renamed from: d */
    public static final SharedPreferences m16553d(Context context) {
        return context.getSharedPreferences("oksdkprefs", 0);
    }

    /* renamed from: e */
    public static boolean m16556e(Context context) {
        return m16553d(context).getString("od_access_token", null) != null;
    }

    /* renamed from: f */
    public static void m16557f(Context context) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager.getInstance().removeAllCookie();
        SharedPreferences.Editor editorEdit = m16553d(context).edit();
        editorEdit.clear();
        C5033j.m19087a(editorEdit);
    }

    /* renamed from: g */
    public static String m16558g(Context context) {
        return m16553d(context).getString("user_name", null);
    }

    /* renamed from: c */
    public static void m16552c(Context context, String str) {
        SharedPreferences.Editor editorEdit = m16553d(context).edit();
        editorEdit.putString("user_name", str);
        C5033j.m19087a(editorEdit);
    }

    /* renamed from: h */
    public static String m16559h(Context context) {
        return m16553d(context).getString("user_id", null);
    }

    /* renamed from: d */
    public static void m16554d(Context context, String str) {
        SharedPreferences.Editor editorEdit = m16553d(context).edit();
        editorEdit.putString("user_id", str);
        C5033j.m19087a(editorEdit);
    }

    /* renamed from: i */
    public static String m16560i(Context context) {
        return m16553d(context).getString("user_profile", null);
    }

    /* renamed from: e */
    public static void m16555e(Context context, String str) {
        SharedPreferences.Editor editorEdit = m16553d(context).edit();
        editorEdit.putString("user_profile", str);
        C5033j.m19087a(editorEdit);
    }
}
