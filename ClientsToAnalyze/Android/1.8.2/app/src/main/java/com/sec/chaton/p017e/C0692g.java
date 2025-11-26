package com.sec.chaton.p017e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.g */
/* loaded from: classes.dex */
public class C0692g implements BaseColumns {

    /* renamed from: a */
    public static final Uri f2614a = C0656a.f2531b.buildUpon().appendPath("buddy_group").build();

    /* renamed from: a */
    public static String m3138a(Uri uri) {
        return uri.getPathSegments().get(1);
    }
}
