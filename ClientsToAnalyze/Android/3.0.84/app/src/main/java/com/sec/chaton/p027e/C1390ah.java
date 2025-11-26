package com.sec.chaton.p027e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.ah */
/* loaded from: classes.dex */
public class C1390ah implements BaseColumns {

    /* renamed from: a */
    public static final Uri f5188a = C1439g.f5367b.buildUpon().appendPath("specialbuddy").build();

    /* renamed from: a */
    public static Uri m6245a() {
        return f5188a.buildUpon().appendEncodedPath("specialbuddy_count").build();
    }
}
