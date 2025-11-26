package com.sec.chaton.p027e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.j */
/* loaded from: classes.dex */
public class C1442j implements BaseColumns {

    /* renamed from: a */
    public static final Uri f5370a = C1439g.f5367b.buildUpon().appendPath("contacts").build();

    /* renamed from: a */
    public static Uri m6320a(String str) {
        return f5370a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static String m6321a(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    /* renamed from: b */
    public static String m6322b(Uri uri) {
        return uri.getPathSegments().get(2);
    }
}
