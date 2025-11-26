package com.sec.chaton.provider;

import android.net.Uri;
import com.sec.chaton.p057e.C2287g;

/* compiled from: ChatONProvider.java */
/* renamed from: com.sec.chaton.provider.b */
/* loaded from: classes.dex */
public class C3037b {

    /* renamed from: a */
    public static final Uri f11271a = Uri.parse("exception://com.sec.chaton.provider");

    /* renamed from: a */
    public static boolean m12496a(Uri uri) {
        return "exception".equalsIgnoreCase(uri.getScheme());
    }

    /* renamed from: a */
    static Uri m12495a(EnumC3038c enumC3038c) {
        return C2287g.f8193a.buildUpon().appendPath(String.valueOf(enumC3038c.m12497a())).build();
    }
}
