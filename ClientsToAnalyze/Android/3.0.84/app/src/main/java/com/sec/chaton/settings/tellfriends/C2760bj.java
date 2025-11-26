package com.sec.chaton.settings.tellfriends;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import twitter4j.Twitter;
import twitter4j.auth.AccessToken;

/* compiled from: TwitterSessionStrore.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bj */
/* loaded from: classes.dex */
public class C2760bj {
    /* renamed from: a */
    public static boolean m9869a(AccessToken accessToken, Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("twitter-session", 0).edit();
        editorEdit.putString("access_token", accessToken.getToken());
        editorEdit.putString("secret_token", accessToken.getTokenSecret());
        return editorEdit.commit();
    }

    /* renamed from: a */
    public static boolean m9868a(Twitter twitter, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("twitter-session", 0);
        try {
            twitter.setOAuthConsumer("FiKaUrK1VKFB5pBaW77aPQ", "yd4oZTePGns9RyeuqXMYMUU1f70VS16sf8WhiCdwSM");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        if (m9870b(context)) {
            twitter.setOAuthAccessToken(new AccessToken(sharedPreferences.getString("access_token", ""), sharedPreferences.getString("secret_token", "")));
            return true;
        }
        return true;
    }

    /* renamed from: a */
    public static void m9866a(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("twitter-session", 0).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    /* renamed from: b */
    public static boolean m9870b(Context context) {
        return context.getSharedPreferences("twitter-session", 0).getString("secret_token", null) != null;
    }

    /* renamed from: c */
    public static String m9872c(Context context) {
        return context.getSharedPreferences("twitter-session", 0).getString("user_name", null);
    }

    /* renamed from: a */
    public static boolean m9867a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("twitter-session", 0).edit();
        editorEdit.putString("user_name", str);
        return editorEdit.commit();
    }

    /* renamed from: d */
    public static String m9874d(Context context) {
        return context.getSharedPreferences("twitter-session", 0).getString("user_id", null);
    }

    /* renamed from: b */
    public static boolean m9871b(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("twitter-session", 0).edit();
        editorEdit.putString("user_id", str);
        return editorEdit.commit();
    }

    /* renamed from: e */
    public static String m9875e(Context context) {
        return context.getSharedPreferences("twitter-session", 0).getString("user_profile", null);
    }

    /* renamed from: c */
    public static boolean m9873c(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("twitter-session", 0).edit();
        editorEdit.putString("user_profile", str);
        return editorEdit.commit();
    }
}
