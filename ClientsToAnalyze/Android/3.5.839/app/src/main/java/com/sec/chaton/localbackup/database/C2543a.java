package com.sec.chaton.localbackup.database;

import android.net.Uri;
import com.p137vk.sdk.api.VKApiConst;

/* compiled from: BackupConstant.java */
/* renamed from: com.sec.chaton.localbackup.database.a */
/* loaded from: classes.dex */
public class C2543a {

    /* renamed from: c */
    private static final Uri f9148c = Uri.parse("content://com.sec.chaton.localbackup");

    /* renamed from: a */
    public static final Uri f9146a = f9148c.buildUpon().appendPath(VKApiConst.MESSAGE).build();

    /* renamed from: b */
    public static final Uri f9147b = f9148c.buildUpon().appendPath("inbox").build();

    /* renamed from: a */
    public static Uri m10947a() {
        return f9148c.buildUpon().appendPath("inbox").build().buildUpon().appendPath("path_inbox").build();
    }

    /* renamed from: b */
    public static Uri m10949b() {
        return f9148c.buildUpon().appendPath("inbox").build().buildUpon().appendPath("path_inbox_normal").build();
    }

    /* renamed from: a */
    public static Uri m10948a(int i) {
        return f9148c.buildUpon().appendPath(VKApiConst.MESSAGE).build().buildUpon().appendPath("path_message").build().buildUpon().appendPath(Integer.toString(i)).build();
    }

    /* renamed from: c */
    public static Uri m10950c() {
        return f9148c.buildUpon().appendPath(VKApiConst.MESSAGE).build().buildUpon().appendPath("path_update_media").build();
    }
}
