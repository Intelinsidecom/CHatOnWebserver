package com.sec.chaton.p027e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.af */
/* loaded from: classes.dex */
public class C1388af implements BaseColumns {

    /* renamed from: a */
    public static final Uri f5186a = C1439g.f5367b.buildUpon().appendPath("recommendee").build();

    /* renamed from: a */
    public static Uri m6243a() {
        return f5186a.buildUpon().appendEncodedPath("recommendee_count").build();
    }
}
