package com.sec.chaton.p017e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.i */
/* loaded from: classes.dex */
public class C0694i implements BaseColumns {

    /* renamed from: a */
    public static final Uri f2616a = C0656a.f2531b.buildUpon().appendPath("inbox").build();

    /* renamed from: a */
    public static Uri m3139a() {
        return f2616a.buildUpon().appendPath("buddy_participant_join").build();
    }

    /* renamed from: b */
    public static Uri m3141b() {
        return f2616a.buildUpon().appendPath("group_title_update").build();
    }

    /* renamed from: c */
    public static Uri m3143c() {
        return f2616a.buildUpon().appendPath("inbox_invalid_update").build();
    }

    /* renamed from: d */
    public static Uri m3144d() {
        return f2616a.buildUpon().appendPath("get_inbox_no").build();
    }

    /* renamed from: a */
    public static String m3140a(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    /* renamed from: b */
    public static String m3142b(Uri uri) {
        return uri.getPathSegments().get(2);
    }
}
