package com.sec.chaton.localbackup.database;

import android.net.Uri;

/* compiled from: BackupConstant.java */
/* renamed from: com.sec.chaton.localbackup.database.a */
/* loaded from: classes.dex */
public class C1641a {

    /* renamed from: b */
    private static final Uri f6103b = Uri.parse("content://com.sec.chaton.localbackup");

    /* renamed from: a */
    public static final Uri f6102a = f6103b.buildUpon().appendPath("message").build();

    /* renamed from: a */
    public static Uri m6916a() {
        return f6103b.buildUpon().appendPath("inbox").build().buildUpon().appendPath("path_inbox").build();
    }

    /* renamed from: a */
    public static Uri m6917a(int i) {
        return f6103b.buildUpon().appendPath("message").build().buildUpon().appendPath("path_message").build().buildUpon().appendPath(Integer.toString(i)).build();
    }

    /* renamed from: b */
    public static Uri m6918b() {
        return f6103b.buildUpon().appendPath("message").build().buildUpon().appendPath("path_update_media").build();
    }
}
