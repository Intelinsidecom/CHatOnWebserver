package com.sec.chaton.sns;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.p137vk.sdk.VKAccessToken;
import com.sec.common.util.C5033j;

/* compiled from: VKontakteSessionStore.java */
/* renamed from: com.sec.chaton.sns.d */
/* loaded from: classes.dex */
public class C4444d {

    /* renamed from: a */
    private static VKAccessToken f16015a;

    public C4444d(Context context) {
        f16015a = VKAccessToken.tokenFromSharedPreferences(context);
    }

    /* renamed from: a */
    public static void m16828a(Context context) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager.getInstance().removeAllCookie();
        SharedPreferences.Editor editorEdit = m16829c(context).edit();
        editorEdit.clear();
        C5033j.m19087a(editorEdit);
    }

    /* renamed from: b */
    public String m16834b(Context context) {
        f16015a = VKAccessToken.tokenFromSharedPreferences(context);
        return f16015a.userId;
    }

    /* renamed from: c */
    public static final SharedPreferences m16829c(Context context) {
        return context.getSharedPreferences(VKAccessToken.SHARED_PREF_NAME, 0);
    }

    /* renamed from: d */
    public String m16836d(Context context) {
        return m16829c(context).getString("user_name", null);
    }

    /* renamed from: e */
    public String m16837e(Context context) {
        return m16829c(context).getString("profile_url", null);
    }

    /* renamed from: a */
    public void m16831a(Context context, String str) {
        SharedPreferences.Editor editorEdit = m16829c(context).edit();
        editorEdit.putString("user_name", str);
        C5033j.m19087a(editorEdit);
    }

    /* renamed from: b */
    public void m16835b(Context context, String str) {
        SharedPreferences.Editor editorEdit = m16829c(context).edit();
        editorEdit.putString("profile_url", str);
        C5033j.m19087a(editorEdit);
    }

    /* renamed from: a */
    public boolean m16832a() {
        if (f16015a == null) {
            return true;
        }
        return f16015a.isExpired();
    }

    /* renamed from: a */
    public void m16830a(Context context, VKAccessToken vKAccessToken) {
        f16015a = vKAccessToken;
        vKAccessToken.saveTokenToSharedPreferences(context);
    }

    /* renamed from: b */
    public VKAccessToken m16833b() {
        return f16015a;
    }
}
