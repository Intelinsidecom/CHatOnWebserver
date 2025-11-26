package com.sec.chaton.p057e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.aq */
/* loaded from: classes.dex */
public class C2229aq implements BaseColumns {

    /* renamed from: a */
    public static final Uri f7957a = C2287g.f8194b.buildUpon().appendPath("relation").build();

    /* renamed from: a */
    public static Uri m10095a(String str) {
        return f7957a.buildUpon().appendPath(str).build();
    }
}
