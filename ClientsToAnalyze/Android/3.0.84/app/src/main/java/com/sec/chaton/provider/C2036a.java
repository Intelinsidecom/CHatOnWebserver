package com.sec.chaton.provider;

import android.net.Uri;
import com.sec.chaton.p027e.C1439g;

/* compiled from: ChatONProvider.java */
/* renamed from: com.sec.chaton.provider.a */
/* loaded from: classes.dex */
public class C2036a {

    /* renamed from: a */
    public static final Uri f7836a = Uri.parse("exception://com.sec.chaton.provider");

    /* renamed from: a */
    public static boolean m8118a(Uri uri) {
        return "exception".equalsIgnoreCase(uri.getScheme());
    }

    /* renamed from: a */
    static Uri m8117a(EnumC2039b enumC2039b) {
        return C1439g.f5366a.buildUpon().appendPath(String.valueOf(enumC2039b.m8154a())).build();
    }
}
