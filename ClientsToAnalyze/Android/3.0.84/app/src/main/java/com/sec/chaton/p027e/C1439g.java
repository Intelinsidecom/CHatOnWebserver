package com.sec.chaton.p027e;

import android.net.Uri;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.g */
/* loaded from: classes.dex */
public class C1439g {

    /* renamed from: b */
    private static final Uri f5367b = Uri.parse("content://com.sec.chaton.provider");

    /* renamed from: a */
    public static final Uri f5366a = f5367b;

    /* renamed from: a */
    public static Uri m6302a() {
        return f5366a.buildUpon().appendPath("inbox").appendPath("delete_old_chat_rooms").build();
    }

    /* renamed from: b */
    public static Uri m6303b() {
        return f5366a.buildUpon().appendPath("inbox").appendPath("chat_list_sync").build();
    }
}
