package com.facebook;

import android.os.Bundle;
import com.facebook.p008b.C0106t;
import java.util.Date;

/* compiled from: TokenCachingStrategy.java */
/* renamed from: com.facebook.bx */
/* loaded from: classes.dex */
public abstract class AbstractC0130bx {
    /* renamed from: a */
    public abstract Bundle mo372a();

    /* renamed from: a */
    public abstract void mo373a(Bundle bundle);

    /* renamed from: b */
    public abstract void mo374b();

    /* renamed from: b */
    public static boolean m377b(Bundle bundle) {
        String string;
        return (bundle == null || (string = bundle.getString("com.facebook.TokenCachingStrategy.Token")) == null || string.length() == 0 || bundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0L) == 0) ? false : true;
    }

    /* renamed from: c */
    public static EnumC0086b m378c(Bundle bundle) {
        C0106t.m277a(bundle, "bundle");
        if (bundle.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource")) {
            return (EnumC0086b) bundle.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource");
        }
        return bundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO") ? EnumC0086b.FACEBOOK_APPLICATION_WEB : EnumC0086b.WEB_VIEW;
    }

    /* renamed from: a */
    static Date m375a(Bundle bundle, String str) {
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
    static void m376a(Bundle bundle, String str, Date date) {
        bundle.putLong(str, date.getTime());
    }
}
