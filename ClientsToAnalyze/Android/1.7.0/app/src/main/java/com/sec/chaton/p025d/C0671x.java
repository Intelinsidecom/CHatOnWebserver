package com.sec.chaton.p025d;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.d.x */
/* loaded from: classes.dex */
public class C0671x implements BaseColumns {

    /* renamed from: a */
    public static final Uri f2315a = C0669v.f2313b.buildUpon().appendPath("inbox").build();

    /* renamed from: a */
    public static Uri m3038a(String str) {
        return f2315a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static Uri m3037a() {
        return f2315a.buildUpon().appendPath("buddy_participant_join").build();
    }

    /* renamed from: b */
    public static Uri m3040b() {
        return f2315a.buildUpon().appendPath("group_title_update").build();
    }

    /* renamed from: c */
    public static Uri m3042c() {
        return f2315a.buildUpon().appendPath("inbox_invalid_update").build();
    }

    /* renamed from: d */
    public static Uri m3043d() {
        return f2315a.buildUpon().appendPath("get_inbox_no").build();
    }

    /* renamed from: a */
    public static String m3039a(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    /* renamed from: b */
    public static String m3041b(Uri uri) {
        return uri.getPathSegments().get(2);
    }
}
