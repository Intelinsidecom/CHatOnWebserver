package com.sec.chaton.p057e;

import android.net.Uri;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.g */
/* loaded from: classes.dex */
public class C2287g {

    /* renamed from: b */
    private static final Uri f8194b = Uri.parse("content://com.sec.chaton.provider");

    /* renamed from: a */
    public static final Uri f8193a = f8194b;

    /* renamed from: a */
    public static Uri m10158a() {
        return f8193a.buildUpon().appendPath("inbox").appendPath("chat_list_sync").build();
    }
}
