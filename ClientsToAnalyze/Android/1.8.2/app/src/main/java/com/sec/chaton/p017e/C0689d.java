package com.sec.chaton.p017e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.d */
/* loaded from: classes.dex */
public class C0689d implements BaseColumns {

    /* renamed from: a */
    public static final Uri f2607a = C0656a.f2531b.buildUpon().appendPath("contacts").build();

    /* renamed from: a */
    public static Uri m3130a(String str) {
        return f2607a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static String m3131a(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    /* renamed from: b */
    public static String m3132b(Uri uri) {
        return uri.getPathSegments().get(2);
    }
}
