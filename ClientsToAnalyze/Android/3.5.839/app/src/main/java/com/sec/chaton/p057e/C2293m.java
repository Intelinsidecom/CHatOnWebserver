package com.sec.chaton.p057e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.m */
/* loaded from: classes.dex */
public class C2293m implements BaseColumns {

    /* renamed from: a */
    public static final Uri f8204a = C2287g.f8194b.buildUpon().appendPath("grouprelation").build();

    /* renamed from: a */
    public static Uri m10179a() {
        return f8204a.buildUpon().appendPath("buddy_in").build();
    }

    /* renamed from: a */
    public static Uri m10180a(String str) {
        return f8204a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static String m10181a(Uri uri) {
        return uri.getPathSegments().get(2);
    }

    /* renamed from: b */
    public static String m10182b(Uri uri) {
        return uri.getPathSegments().get(2);
    }
}
