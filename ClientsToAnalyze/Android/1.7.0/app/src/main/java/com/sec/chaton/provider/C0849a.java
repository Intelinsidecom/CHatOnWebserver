package com.sec.chaton.provider;

import android.net.Uri;
import com.sec.chaton.p025d.C0669v;
import com.sec.chaton.util.C1341p;

/* compiled from: ChatONProvider.java */
/* renamed from: com.sec.chaton.provider.a */
/* loaded from: classes.dex */
public class C0849a {

    /* renamed from: a */
    public static final Uri f2939a = Uri.parse("exception://com.sec.chaton.provider");

    /* renamed from: a */
    public static boolean m3432a(Uri uri) {
        return "exception".equalsIgnoreCase(uri.getScheme());
    }

    /* renamed from: a */
    static Uri m3431a(EnumC0850b enumC0850b) {
        return C0669v.f2312a.buildUpon().appendPath(String.valueOf(enumC0850b.m3435a())).build();
    }

    /* renamed from: b */
    public static EnumC0850b m3433b(Uri uri) {
        EnumC0850b enumC0850b = EnumC0850b.UNKNOWN;
        try {
            return EnumC0850b.m3434a(Integer.parseInt(uri.getPathSegments().get(1)));
        } catch (NumberFormatException e) {
            C1341p.m4653a(e, "DBExceptionURIMaker");
            return enumC0850b;
        }
    }
}
