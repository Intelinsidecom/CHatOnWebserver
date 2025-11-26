package com.sec.chaton.p057e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.ap */
/* loaded from: classes.dex */
public class C2228ap implements BaseColumns {

    /* renamed from: a */
    public static final Uri f7956a = C2287g.f8194b.buildUpon().appendPath("recommendee").build();

    /* renamed from: a */
    public static Uri m10094a() {
        return f7956a.buildUpon().appendEncodedPath("recommendee_count").build();
    }
}
