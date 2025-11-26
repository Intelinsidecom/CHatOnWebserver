package com.sec.chaton.p027e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.m */
/* loaded from: classes.dex */
public class C1445m implements BaseColumns {

    /* renamed from: a */
    public static final Uri f5377a = C1439g.f5367b.buildUpon().appendPath("grouprelation").build();

    /* renamed from: a */
    public static Uri m6323a() {
        return f5377a.buildUpon().appendPath("buddy_in").build();
    }

    /* renamed from: a */
    public static Uri m6324a(String str) {
        return f5377a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static String m6325a(Uri uri) {
        return uri.getPathSegments().get(2);
    }

    /* renamed from: b */
    public static String m6326b(Uri uri) {
        return uri.getPathSegments().get(2);
    }
}
