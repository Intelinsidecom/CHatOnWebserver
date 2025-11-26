package com.sec.chaton.p027e;

import android.net.Uri;
import android.provider.BaseColumns;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.q */
/* loaded from: classes.dex */
public class C1449q implements BaseColumns {

    /* renamed from: a */
    public static final Uri f5381a = C1439g.f5367b.buildUpon().appendPath("inbox").build();

    /* renamed from: a */
    public static Uri m6329a(String str) {
        return f5381a.buildUpon().appendPath(str).build();
    }

    /* renamed from: a */
    public static Uri m6328a() {
        return f5381a.buildUpon().appendPath("buddy_participant_join").build();
    }

    /* renamed from: b */
    public static Uri m6331b() {
        return f5381a.buildUpon().appendPath("buddy_participant_join_for_list").build();
    }

    /* renamed from: c */
    public static Uri m6333c() {
        return f5381a.buildUpon().appendPath("buddy_participant_join_for_list_of_forward").build();
    }

    /* renamed from: d */
    public static Uri m6334d() {
        return f5381a.buildUpon().appendPath("update_unread_count").build();
    }

    /* renamed from: e */
    public static Uri m6335e() {
        return f5381a.buildUpon().appendPath("update_inbox_with_current_unread_count").build();
    }

    /* renamed from: f */
    public static Uri m6336f() {
        return f5381a.buildUpon().appendPath("inbox_invalid_update").build();
    }

    /* renamed from: g */
    public static Uri m6337g() {
        return f5381a.buildUpon().appendPath("get_inbox_no").build();
    }

    /* renamed from: h */
    public static Uri m6338h() {
        return f5381a.buildUpon().appendPath("update_for_push").build();
    }

    /* renamed from: a */
    public static String m6330a(Uri uri) {
        return uri.getPathSegments().get(1);
    }

    /* renamed from: b */
    public static String m6332b(Uri uri) {
        return uri.getPathSegments().get(2);
    }
}
