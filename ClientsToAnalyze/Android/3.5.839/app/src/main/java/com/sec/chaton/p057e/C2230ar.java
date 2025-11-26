package com.sec.chaton.p057e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.ar */
/* loaded from: classes.dex */
public class C2230ar implements BaseColumns {

    /* renamed from: a */
    public static final Uri f7958a = C2287g.f8194b.buildUpon().appendPath("specialbuddy").build();

    /* renamed from: a */
    public static Uri m10096a() {
        return f7958a.buildUpon().appendEncodedPath("specialbuddy_count").build();
    }

    /* renamed from: b */
    public static Uri m10097b() {
        return f7958a.buildUpon().appendEncodedPath("specialbuddy_join_participants").build();
    }
}
