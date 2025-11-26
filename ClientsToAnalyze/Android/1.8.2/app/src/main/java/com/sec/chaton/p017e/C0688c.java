package com.sec.chaton.p017e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.c */
/* loaded from: classes.dex */
public class C0688c implements BaseColumns {

    /* renamed from: a */
    public static final Uri f2606a = C0656a.f2531b.buildUpon().appendPath("buddy").build();

    /* renamed from: a */
    public static Uri m3121a(String str) {
        return f2606a.buildUpon().appendPath("buddy_no").appendPath(str).build();
    }

    /* renamed from: a */
    public static Uri m3120a() {
        return f2606a.buildUpon().appendEncodedPath("alphabetical").build();
    }

    /* renamed from: b */
    public static Uri m3123b() {
        return f2606a.buildUpon().appendEncodedPath("alphabetical2").build();
    }

    /* renamed from: c */
    public static Uri m3125c() {
        return f2606a.buildUpon().appendEncodedPath("relation").build();
    }

    /* renamed from: d */
    public static Uri m3126d() {
        return f2606a.buildUpon().appendPath("profile").build();
    }

    /* renamed from: e */
    public static Uri m3127e() {
        return f2606a.buildUpon().appendPath("participants").build();
    }

    /* renamed from: f */
    public static Uri m3128f() {
        return f2606a.buildUpon().appendPath("participants_no_same").build();
    }

    /* renamed from: g */
    public static Uri m3129g() {
        return f2606a.buildUpon().appendEncodedPath("alphabetical_special").build();
    }

    /* renamed from: a */
    public static String m3122a(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    /* renamed from: b */
    public static String m3124b(Uri uri) {
        return uri.getPathSegments().get(2);
    }
}
