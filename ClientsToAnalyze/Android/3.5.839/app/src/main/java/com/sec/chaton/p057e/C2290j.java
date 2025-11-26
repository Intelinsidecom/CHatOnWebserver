package com.sec.chaton.p057e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.j */
/* loaded from: classes.dex */
public class C2290j implements BaseColumns {

    /* renamed from: a */
    public static final Uri f8197a = C2287g.f8194b.buildUpon().appendPath("contacts").build();

    /* renamed from: a */
    public static Uri m10176a(String str) {
        return f8197a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static String m10177a(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    /* renamed from: b */
    public static String m10178b(Uri uri) {
        return uri.getPathSegments().get(2);
    }
}
