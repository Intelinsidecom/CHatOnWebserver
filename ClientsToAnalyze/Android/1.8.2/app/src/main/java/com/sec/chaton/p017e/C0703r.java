package com.sec.chaton.p017e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.r */
/* loaded from: classes.dex */
public class C0703r implements BaseColumns {

    /* renamed from: a */
    public static final Uri f2646a = C0656a.f2531b.buildUpon().appendPath("relation").build();

    /* renamed from: a */
    public static Uri m3167a(String str) {
        return f2646a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static Uri m3166a() {
        return f2646a.buildUpon().appendPath("day").build();
    }

    /* renamed from: b */
    public static Uri m3168b() {
        return f2646a.buildUpon().appendPath("insert").build();
    }
}
