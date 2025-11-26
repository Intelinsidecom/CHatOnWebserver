package com.sec.chaton.p027e;

import android.net.Uri;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.y */
/* loaded from: classes.dex */
public class C1457y {

    /* renamed from: a */
    public static final Uri f5415a = C1439g.f5367b.buildUpon().appendPath("participant").build();

    /* renamed from: a */
    public static Uri m6367a(String str) {
        return f5415a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static final String m6368a(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    /* renamed from: a */
    public static Uri m6366a() {
        return f5415a.buildUpon().appendPath("name_join_buddy").build();
    }
}
