package com.sec.chaton.p057e;

import android.net.Uri;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.af */
/* loaded from: classes.dex */
public class C2218af implements InterfaceC2217ae {

    /* renamed from: a */
    public static final Uri f7940a = C2287g.f8194b.buildUpon().appendPath("multichannel_upload").build();

    /* renamed from: a */
    public static Uri m10084a(long j) {
        return f7940a.buildUpon().appendPath("request_id").appendPath(String.valueOf(j)).build();
    }
}
