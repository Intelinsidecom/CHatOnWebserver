package com.sec.chaton.settings.tellfriends;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: RenrenSessionStore.java */
/* renamed from: com.sec.chaton.settings.tellfriends.u */
/* loaded from: classes.dex */
public class C2827u {
    /* renamed from: a */
    public static String m10058a(Context context) {
        return context.getSharedPreferences("renren_sdk_config", 0).getString("user_name", null);
    }

    /* renamed from: a */
    public static boolean m10059a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("renren_sdk_config", 0).edit();
        editorEdit.putString("user_name", str);
        return editorEdit.commit();
    }

    /* renamed from: b */
    public static String m10060b(Context context) {
        return context.getSharedPreferences("renren_sdk_config", 0).getString("user_id", null);
    }

    /* renamed from: b */
    public static boolean m10061b(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("renren_sdk_config", 0).edit();
        editorEdit.putString("user_id", str);
        return editorEdit.commit();
    }

    /* renamed from: c */
    public static String m10062c(Context context) {
        return context.getSharedPreferences("renren_sdk_config", 0).getString("user_profile", null);
    }

    /* renamed from: c */
    public static boolean m10063c(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("renren_sdk_config", 0).edit();
        editorEdit.putString("user_profile", str);
        return editorEdit.commit();
    }
}
