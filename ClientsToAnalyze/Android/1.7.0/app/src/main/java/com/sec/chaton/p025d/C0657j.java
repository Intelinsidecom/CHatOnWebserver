package com.sec.chaton.p025d;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.d.j */
/* loaded from: classes.dex */
public class C0657j implements BaseColumns {

    /* renamed from: a */
    public static final Uri f2284a = C0669v.f2313b.buildUpon().appendPath("contacts").build();

    /* renamed from: a */
    public static Uri m2987a(String str) {
        return f2284a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static String m2988a(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    /* renamed from: b */
    public static String m2989b(Uri uri) {
        return uri.getPathSegments().get(2);
    }
}
