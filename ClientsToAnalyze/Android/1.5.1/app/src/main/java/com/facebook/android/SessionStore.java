package com.facebook.android;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class SessionStore {
    /* renamed from: a */
    public static void m254a(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    /* renamed from: a */
    public static boolean m255a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.putString("user_email", str);
        return editorEdit.commit();
    }

    /* renamed from: a */
    public static boolean m256a(Facebook facebook, Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.putString("access_token", facebook.m241b());
        editorEdit.putLong("expires_in", facebook.m243c());
        return editorEdit.commit();
    }

    /* renamed from: b */
    public static String m257b(Context context) {
        return context.getSharedPreferences("facebook-session", 0).getString("user_email", null);
    }

    /* renamed from: b */
    public static boolean m258b(Facebook facebook, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("facebook-session", 0);
        facebook.m239a(sharedPreferences.getString("access_token", null));
        facebook.m235a(sharedPreferences.getLong("expires_in", 0L));
        return facebook.m240a();
    }
}
