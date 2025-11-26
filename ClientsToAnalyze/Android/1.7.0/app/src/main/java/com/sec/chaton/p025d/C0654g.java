package com.sec.chaton.p025d;

import android.net.Uri;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.d.g */
/* loaded from: classes.dex */
public class C0654g {

    /* renamed from: a */
    public static final Uri f2279a = C0669v.f2313b.buildUpon().appendPath("participant").build();

    /* renamed from: a */
    public static Uri m2980a(String str) {
        return f2279a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static final String m2981a(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    /* renamed from: a */
    public static Uri m2979a() {
        return f2279a.buildUpon().appendPath("name_join_buddy").build();
    }
}
