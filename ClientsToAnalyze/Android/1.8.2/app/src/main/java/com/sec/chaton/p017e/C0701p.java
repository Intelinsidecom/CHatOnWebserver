package com.sec.chaton.p017e;

import android.net.Uri;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.p */
/* loaded from: classes.dex */
public class C0701p {

    /* renamed from: a */
    public static final Uri f2644a = C0656a.f2531b.buildUpon().appendPath("participant").build();

    /* renamed from: a */
    public static Uri m3164a(String str) {
        return f2644a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static final String m3165a(Uri uri) {
        return uri.getPathSegments().get(1);
    }
}
