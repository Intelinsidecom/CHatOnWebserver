package com.sec.chaton.p027e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.ag */
/* loaded from: classes.dex */
public class C1389ag implements BaseColumns {

    /* renamed from: a */
    public static final Uri f5187a = C1439g.f5367b.buildUpon().appendPath("relation").build();

    /* renamed from: a */
    public static Uri m6244a(String str) {
        return f5187a.buildUpon().appendPath(str).build();
    }
}
