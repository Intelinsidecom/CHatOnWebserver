package com.sec.chaton.p025d;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.d.t */
/* loaded from: classes.dex */
public class C0667t implements BaseColumns {

    /* renamed from: a */
    public static final Uri f2310a = C0669v.f2313b.buildUpon().appendPath("buddy").build();

    /* renamed from: a */
    public static Uri m3024a(String str) {
        return f2310a.buildUpon().appendPath("buddy_no").appendPath(str).build();
    }

    /* renamed from: a */
    public static Uri m3023a() {
        return f2310a.buildUpon().appendEncodedPath("alphabetical").build();
    }

    /* renamed from: b */
    public static Uri m3026b() {
        return f2310a.buildUpon().appendEncodedPath("alphabetical2").build();
    }

    /* renamed from: c */
    public static Uri m3028c() {
        return f2310a.buildUpon().appendEncodedPath("relation").build();
    }

    /* renamed from: d */
    public static Uri m3029d() {
        return f2310a.buildUpon().appendPath("profile").build();
    }

    /* renamed from: e */
    public static Uri m3030e() {
        return f2310a.buildUpon().appendPath("participants").build();
    }

    /* renamed from: f */
    public static Uri m3031f() {
        return f2310a.buildUpon().appendPath("participants_no_same").build();
    }

    /* renamed from: a */
    public static String m3025a(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    /* renamed from: b */
    public static String m3027b(Uri uri) {
        return uri.getPathSegments().get(2);
    }
}
