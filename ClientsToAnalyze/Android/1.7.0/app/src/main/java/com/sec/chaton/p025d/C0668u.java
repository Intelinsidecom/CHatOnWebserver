package com.sec.chaton.p025d;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.d.u */
/* loaded from: classes.dex */
public class C0668u implements BaseColumns {

    /* renamed from: a */
    public static final Uri f2311a = C0669v.f2313b.buildUpon().appendPath("grouprelation").build();

    /* renamed from: a */
    public static Uri m3032a() {
        return f2311a.buildUpon().appendPath("buddy_in").build();
    }

    /* renamed from: a */
    public static Uri m3033a(String str) {
        return f2311a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static String m3034a(Uri uri) {
        return uri.getPathSegments().get(2);
    }

    /* renamed from: b */
    public static String m3035b(Uri uri) {
        return uri.getPathSegments().get(2);
    }
}
