package com.sec.chaton.settings.tellfriends;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import weibo4android.Weibo;
import weibo4android.http.AccessToken;

/* compiled from: WeiboSessionStore.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cc */
/* loaded from: classes.dex */
public class C2780cc {
    /* renamed from: a */
    public static boolean m9917a(AccessToken accessToken, Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("weibo-session", 0).edit();
        editorEdit.putString("access_token", accessToken.getToken());
        editorEdit.putString("secret_token", accessToken.getTokenSecret());
        return editorEdit.commit();
    }

    /* renamed from: a */
    public static boolean m9916a(Weibo weibo, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("weibo-session", 0);
        try {
            weibo.setOAuthConsumer("1549470309", "a7d96376036a4b35a3e7a1e24632bd88");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        if (m9918b(context)) {
            weibo.setOAuthAccessToken(new AccessToken(sharedPreferences.getString("access_token", ""), sharedPreferences.getString("secret_token", "")));
            return true;
        }
        return true;
    }

    /* renamed from: a */
    public static void m9914a(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("weibo-session", 0).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    /* renamed from: b */
    public static boolean m9918b(Context context) {
        return context.getSharedPreferences("weibo-session", 0).getString("secret_token", null) != null;
    }

    /* renamed from: c */
    public static String m9920c(Context context) {
        return context.getSharedPreferences("weibo-session", 0).getString("user_name", null);
    }

    /* renamed from: a */
    public static boolean m9915a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("weibo-session", 0).edit();
        editorEdit.putString("user_name", str);
        return editorEdit.commit();
    }

    /* renamed from: d */
    public static String m9922d(Context context) {
        return context.getSharedPreferences("weibo-session", 0).getString("user_id", null);
    }

    /* renamed from: b */
    public static boolean m9919b(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("weibo-session", 0).edit();
        editorEdit.putString("user_id", str);
        return editorEdit.commit();
    }

    /* renamed from: e */
    public static String m9923e(Context context) {
        return context.getSharedPreferences("weibo-session", 0).getString("user_profile", null);
    }

    /* renamed from: c */
    public static boolean m9921c(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("weibo-session", 0).edit();
        editorEdit.putString("user_profile", str);
        return editorEdit.commit();
    }
}
