package com.facebook;

import android.os.Bundle;
import com.facebook.p032b.C0477t;
import java.util.Date;

/* compiled from: TokenCachingStrategy.java */
/* renamed from: com.facebook.bx */
/* loaded from: classes.dex */
public abstract class AbstractC0501bx {
    /* renamed from: a */
    public abstract Bundle mo1815a();

    /* renamed from: a */
    public abstract void mo1816a(Bundle bundle);

    /* renamed from: b */
    public abstract void mo1817b();

    /* renamed from: b */
    public static boolean m1820b(Bundle bundle) {
        String string;
        return (bundle == null || (string = bundle.getString("com.facebook.TokenCachingStrategy.Token")) == null || string.length() == 0 || bundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0L) == 0) ? false : true;
    }

    /* renamed from: c */
    public static EnumC0457b m1821c(Bundle bundle) {
        C0477t.m1721a(bundle, "bundle");
        if (bundle.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource")) {
            return (EnumC0457b) bundle.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource");
        }
        return bundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO") ? EnumC0457b.FACEBOOK_APPLICATION_WEB : EnumC0457b.WEB_VIEW;
    }

    /* renamed from: a */
    static Date m1818a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        long j = bundle.getLong(str, Long.MIN_VALUE);
        if (j != Long.MIN_VALUE) {
            return new Date(j);
        }
        return null;
    }

    /* renamed from: a */
    static void m1819a(Bundle bundle, String str, Date date) {
        bundle.putLong(str, date.getTime());
    }
}
