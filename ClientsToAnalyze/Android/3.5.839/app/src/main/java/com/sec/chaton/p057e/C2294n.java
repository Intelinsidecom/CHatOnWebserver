package com.sec.chaton.p057e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.n */
/* loaded from: classes.dex */
public class C2294n implements BaseColumns {

    /* renamed from: a */
    public static final Uri f8205a = C2287g.f8194b.buildUpon().appendPath("buddy_group").build();

    /* renamed from: a */
    public static String m10183a(Uri uri) {
        return uri.getPathSegments().get(1);
    }
}
