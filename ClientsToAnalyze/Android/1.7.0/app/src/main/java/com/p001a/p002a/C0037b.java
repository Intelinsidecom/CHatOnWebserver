package com.p001a.p002a;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SessionStore.java */
/* renamed from: com.a.a.b */
/* loaded from: classes.dex */
public class C0037b {
    /* renamed from: a */
    public static boolean m12a(C0043h c0043h, Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.putString("access_token", c0043h.m33b());
        editorEdit.putLong("expires_in", c0043h.m35c());
        return editorEdit.commit();
    }

    /* renamed from: b */
    public static boolean m14b(C0043h c0043h, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("facebook-session", 0);
        c0043h.m31a(sharedPreferences.getString("access_token", null));
        c0043h.m27a(sharedPreferences.getLong("expires_in", 0L));
        return c0043h.m32a();
    }

    /* renamed from: a */
    public static void m10a(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    /* renamed from: b */
    public static String m13b(Context context) {
        return context.getSharedPreferences("facebook-session", 0).getString("user_email", null);
    }

    /* renamed from: a */
    public static boolean m11a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("facebook-session", 0).edit();
        editorEdit.putString("user_email", str);
        return editorEdit.commit();
    }
}
