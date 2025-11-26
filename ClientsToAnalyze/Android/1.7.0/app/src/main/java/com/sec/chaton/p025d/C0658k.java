package com.sec.chaton.p025d;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.d.k */
/* loaded from: classes.dex */
public class C0658k implements BaseColumns {

    /* renamed from: a */
    public static final Uri f2285a = C0669v.f2313b.buildUpon().appendPath("relation").build();

    /* renamed from: a */
    public static Uri m2991a(String str) {
        return f2285a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static Uri m2990a() {
        return f2285a.buildUpon().appendPath("day").build();
    }

    /* renamed from: b */
    public static Uri m2992b() {
        return f2285a.buildUpon().appendPath("insert").build();
    }
}
