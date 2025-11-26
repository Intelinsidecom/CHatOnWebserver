package com.sec.chaton.p027e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.n */
/* loaded from: classes.dex */
public class C1446n implements BaseColumns {

    /* renamed from: a */
    public static final Uri f5378a = C1439g.f5367b.buildUpon().appendPath("buddy_group").build();

    /* renamed from: a */
    public static String m6327a(Uri uri) {
        return uri.getPathSegments().get(1);
    }
}
