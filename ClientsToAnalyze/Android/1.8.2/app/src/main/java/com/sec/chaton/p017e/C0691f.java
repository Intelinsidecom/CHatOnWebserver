package com.sec.chaton.p017e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.f */
/* loaded from: classes.dex */
public class C0691f implements BaseColumns {

    /* renamed from: a */
    public static final Uri f2613a = C0656a.f2531b.buildUpon().appendPath("grouprelation").build();

    /* renamed from: a */
    public static Uri m3133a() {
        return f2613a.buildUpon().appendPath("buddy_in").build();
    }

    /* renamed from: a */
    public static Uri m3134a(String str) {
        return f2613a.buildUpon().appendPath(str).build();
    }

    /* renamed from: b */
    public static Uri m3136b() {
        return f2613a.buildUpon().appendPath("group").build();
    }

    /* renamed from: a */
    public static String m3135a(Uri uri) {
        return uri.getPathSegments().get(2);
    }

    /* renamed from: b */
    public static String m3137b(Uri uri) {
        return uri.getPathSegments().get(2);
    }
}
