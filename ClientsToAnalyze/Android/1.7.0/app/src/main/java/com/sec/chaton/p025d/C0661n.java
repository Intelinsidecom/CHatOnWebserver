package com.sec.chaton.p025d;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.d.n */
/* loaded from: classes.dex */
public class C0661n implements BaseColumns {

    /* renamed from: a */
    public static final Uri f2288a = C0669v.f2313b.buildUpon().appendPath("buddy_group").build();

    /* renamed from: a */
    public static String m2993a(Uri uri) {
        return uri.getPathSegments().get(1);
    }
}
