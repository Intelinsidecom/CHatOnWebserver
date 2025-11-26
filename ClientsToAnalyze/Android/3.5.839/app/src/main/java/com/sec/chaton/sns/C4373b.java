package com.sec.chaton.sns;

import android.content.Context;
import android.content.SharedPreferences;
import com.sec.common.util.C5033j;

/* compiled from: RenrenSessionStore.java */
/* renamed from: com.sec.chaton.sns.b */
/* loaded from: classes.dex */
public class C4373b {
    /* renamed from: a */
    public static String m16581a(Context context) {
        return context.getSharedPreferences("renren_sdk_config", 0).getString("user_name", null);
    }

    /* renamed from: a */
    public static boolean m16582a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("renren_sdk_config", 0).edit();
        editorEdit.putString("user_name", str);
        C5033j.m19087a(editorEdit);
        return true;
    }

    /* renamed from: b */
    public static String m16583b(Context context) {
        return context.getSharedPreferences("renren_sdk_config", 0).getString("user_id", null);
    }

    /* renamed from: b */
    public static boolean m16584b(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("renren_sdk_config", 0).edit();
        editorEdit.putString("user_id", str);
        C5033j.m19087a(editorEdit);
        return true;
    }

    /* renamed from: c */
    public static String m16585c(Context context) {
        return context.getSharedPreferences("renren_sdk_config", 0).getString("user_profile", null);
    }

    /* renamed from: c */
    public static boolean m16586c(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("renren_sdk_config", 0).edit();
        editorEdit.putString("user_profile", str);
        C5033j.m19087a(editorEdit);
        return true;
    }
}
