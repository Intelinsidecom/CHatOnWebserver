package com.sec.chaton.sns;

import android.content.Context;
import android.content.SharedPreferences;
import com.sec.common.util.C5033j;
import p010b.InterfaceC0319f;
import p010b.p012b.C0272a;

/* compiled from: TwitterSessionStrore.java */
/* renamed from: com.sec.chaton.sns.c */
/* loaded from: classes.dex */
public class C4443c {
    /* renamed from: a */
    public static boolean m16821a(C0272a c0272a, Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("twitter-session", 0).edit();
        editorEdit.putString("access_token", c0272a.mo954c());
        editorEdit.putString("secret_token", c0272a.mo953b());
        C5033j.m19087a(editorEdit);
        return true;
    }

    /* renamed from: a */
    public static boolean m16822a(InterfaceC0319f interfaceC0319f, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("twitter-session", 0);
        try {
            interfaceC0319f.mo973b("FiKaUrK1VKFB5pBaW77aPQ", "yd4oZTePGns9RyeuqXMYMUU1f70VS16sf8WhiCdwSM");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        if (m16819a(context)) {
            interfaceC0319f.mo972a(new C0272a(sharedPreferences.getString("access_token", ""), sharedPreferences.getString("secret_token", "")));
            return true;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m16819a(Context context) {
        return context.getSharedPreferences("twitter-session", 0).getString("secret_token", null) != null;
    }

    /* renamed from: b */
    public static String m16823b(Context context) {
        return context.getSharedPreferences("twitter-session", 0).getString("user_name", null);
    }

    /* renamed from: a */
    public static boolean m16820a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("twitter-session", 0).edit();
        editorEdit.putString("user_name", str);
        C5033j.m19087a(editorEdit);
        return true;
    }

    /* renamed from: c */
    public static String m16825c(Context context) {
        return context.getSharedPreferences("twitter-session", 0).getString("user_id", null);
    }

    /* renamed from: b */
    public static boolean m16824b(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("twitter-session", 0).edit();
        editorEdit.putString("user_id", str);
        C5033j.m19087a(editorEdit);
        return true;
    }

    /* renamed from: d */
    public static String m16827d(Context context) {
        return context.getSharedPreferences("twitter-session", 0).getString("user_profile", null);
    }

    /* renamed from: c */
    public static boolean m16826c(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("twitter-session", 0).edit();
        editorEdit.putString("user_profile", str);
        C5033j.m19087a(editorEdit);
        return true;
    }
}
